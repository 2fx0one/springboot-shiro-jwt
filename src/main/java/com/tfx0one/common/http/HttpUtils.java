package com.tfx0one.common.http;

/*
 * Create by 2fx0one on 2018/3/16
 */



import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtils {

    public static final MediaType CONTENT_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private static final MediaType CONTENT_TYPE_FORM = MediaType.parse("application/xml");

    private static Lock lock = new ReentrantLock();

    private static OkHttpClient clientSsl;
    
    /** 
    * @Description:  
    * @Param:  
    * @return:  
    * @Author: Mr.Wang 
    * @Date: 2018/11/6 
    */ 
    private static OkHttpClient client = new OkHttpClient().newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();


    /*post 方法 xml */
    /**
    * @Description:  post 传递xmp
    * @Param: [url, params]
    * @return: java.lang.String
    * @Author: wangk
    * @CreateTime: 2018/11/6
    */
    static String postXML(String url, String params) {
        RequestBody body = RequestBody.create(CONTENT_TYPE_FORM, params);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return StringExecute(request);
    }

    public static String get(String url) {
        Request request = new Request.Builder().url(url).build();
        return StringExecute(request);
    }

    public static byte[] getBytes(String url) {
        Request request = new Request.Builder().url(url).build();
        return byteExecute(request);
    }

    private static String StringExecute(Request request) {
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] byteExecute(Request request) {
        try {
            Response response = client.newCall(request).execute();
            return response.body().bytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String postSSL(String url, String xmlData, String certPath, String certPass) {
        RequestBody body = RequestBody.create(CONTENT_TYPE_FORM, xmlData);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        InputStream inputStream = null;
        try {
            // 移动到最开始，certPath io异常unlock会报错
            lock.lock();

            KeyStore clientStore = KeyStore.getInstance("PKCS12");
            inputStream = HttpUtils.class.getResourceAsStream(certPath);
            System.out.println(inputStream.available());
//            inputStream = new FileInputStream(certPath);
            clientStore.load(inputStream, certPass.toCharArray());

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(clientStore, certPass.toCharArray());
            KeyManager[] kms = kmf.getKeyManagers();
            SSLContext sslContext = SSLContext.getInstance("TLSv1");

            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };

            sslContext.init(kms, new TrustManager[]{trustManager}, new SecureRandom());

            if (clientSsl == null) {
                clientSsl = new OkHttpClient().newBuilder()
                        .sslSocketFactory(sslContext.getSocketFactory(), trustManager)
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .writeTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .build();
            }

//            clientSsl.setSslSocketFactory(sslContext.getSocketFactory());

            Response response = clientSsl.newCall(request).execute();

            if (!response.isSuccessful()) throw new RuntimeException("Unexpected code " + response);

            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException(e);

        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
        return null;
    }
}
