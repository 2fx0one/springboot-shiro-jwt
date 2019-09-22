package com.tfx0one.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tfx0one.common.constant.GlobalConstant;
import com.tfx0one.modules.app.entity.UserEntity;
import com.tfx0one.modules.sys.entity.SysUserEntity;

import java.util.Date;

public class JWTUtils {
    private static final int EXPIRE_TIME_IN_SECOND = GlobalConstant.JWT_REDIS_EXPIRE_TIME_IN_SECOND;

    public static boolean isTokenExpired(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt().before(new Date());
    }

    /**
     * 校验token是否正确 过期会返回 false
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
//            DecodedJWT jwt = verifier.verify(token);
            verifier.verify(token);

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
     * @param user 系统 用户
     * @return 加密的token
     */
    public static String sign(SysUserEntity user) {
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME_IN_SECOND * 1000);
        Algorithm algorithm = Algorithm.HMAC256(user.getPassword());
        // 附带username信息
        return JWT.create()
                .withSubject(user.getUserId().toString())
                .withClaim("username", user.getUsername())
                .withExpiresAt(expireDate)
                .sign(algorithm);
    }

    //app 用户 分离 不放一起
//    public static String sign(UserEntity user) {
//        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME_IN_SECOND * 1000);
//        Algorithm algorithm = Algorithm.HMAC256(user.getPassword());
//        // 附带username信息
//        return JWT.create()
//                .withIssuedAt(new Date())
//                .withSubject(user.getUserId().toString())
//                .withClaim("username", user.getUsername())
//                .withExpiresAt(expireDate)
//                .sign(algorithm);
//    }

    public static void main(String[] args) {
//        SysUserEntity user = new SysUserEntity();
//        user.setUserId(1L);
//        user.setUsername("admin");
//        user.setPassword("p1");
//        String sign = sign(user);
//        System.out.println("sign = " + sign);

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiZXhwIjoxNTYyNTU3MDg3LCJ1c2VybmFtZSI6ImFkbWluIn0.Y9eycEAtJquimq2rONyaMTSBpCKjTiYQWNbV_84SWkY";
        System.out.println("getUserId(token) = " + getUserId(token));
        boolean verify = verify(token, "admin", "p1");
        System.out.println("verify = " + verify);
    }
}