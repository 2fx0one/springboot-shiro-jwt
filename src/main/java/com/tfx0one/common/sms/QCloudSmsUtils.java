package com.tfx0one.common.sms;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import java.text.MessageFormat;
import java.util.Random;

/**
 * Created by 2fx0one on 2018/7/20.
 */
public class QCloudSmsUtils {

    //TODO config file
    private static int appId = 1400082902;
    private static String key = "ae35003edfeef442d38be4b1f9d42626";

    private static String smsVerificationCode = "您绑定商城的验证码{0},请在3分钟之内填写请不要告诉其他人."; //159603

    private static String smsSign = "【闲约科技】"; //暂时用不上。


    private static SmsSingleSenderResult sendSMStoMobilePhone(String mobilPhone, String msg) {
        try {
            SmsSingleSender sender = new SmsSingleSender(appId, key);
            String log = "正在发送短信给 [ " + mobilPhone + " ]...  内容为： \"" + msg + "\"";
            System.out.println(log);
            SmsSingleSenderResult result = sender.send(0, "86", mobilPhone, msg, "", "");

            System.out.println(result);
//            System.out.println(result.errMsg);

//            System.out.println("发送" + (result.result == 0 ? "成功" : "失败"));

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SmsSingleSenderResult sendSmsWithVerificationCode(String mobilPhone, Integer code) {
            String msg = MessageFormat.format(smsVerificationCode, code.toString());
            return sendSMStoMobilePhone(mobilPhone, msg);
    }

    private static Random random = new Random(System.currentTimeMillis());

    public static Integer generateVerificationCode() {
        return random.nextInt(9000) + 1000;
    }

    public static void main(String[] args) throws Exception {
        sendSmsWithVerificationCode("1397009017", 1234);
    }
}
