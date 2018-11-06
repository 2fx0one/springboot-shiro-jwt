package com.tfx0one.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 2fx0one on 2018/6/16.
 */
public class IpUtils {

    public static String getClientIpAddr(HttpServletRequest request) {
//        System.out.println("X-Real-IP: " + request.getHeader("X-Real-IP"));
//        System.out.println("X-Forwarded-For: " + request.getHeader("X-Forwarded-For"));
        // 项目使用了 nginx 代理服务器 配置了 proxy_set_header  X-real-remoteAddr $remote_addr;
        String remoteAddr = request.getHeader("x-forwarded-for");
        if (remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        }

        if (remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr)) {
            remoteAddr = request.getHeader("X-Forwarded-For");
        }

        if (remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }

        if (remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr)) {
            remoteAddr = request.getHeader("X-Real-IP");
        }

//        if (remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr)) {
//            remoteAddr = request.getRemoteAddr();
//        }

        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
    }
}
