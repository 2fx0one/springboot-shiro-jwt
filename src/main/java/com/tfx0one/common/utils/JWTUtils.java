package com.tfx0one.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tfx0one.sys.entity.User;

import java.util.Date;

public class JWTUtils {
    // 过期时间 1 小时
    public static final int EXPIRE_TIME_SECOND = 60 * 60;

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getSubject();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     *
     * @param user 用户
     * @return 加密的token
     */
    public static String sign(User user) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME_SECOND*1000);
        Algorithm algorithm = Algorithm.HMAC256(user.getPassword());
        // 附带username信息
        return JWT.create()
                .withSubject(user.getId())
                .withClaim("username", user.getLoginName())
                .withExpiresAt(date)
                .sign(algorithm);
    }

//    public static String sign(User user) {
//        return sign(user.getLoginName(), user.getPassword());
//    }
}