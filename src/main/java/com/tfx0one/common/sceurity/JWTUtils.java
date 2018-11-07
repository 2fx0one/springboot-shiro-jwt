package com.tfx0one.common.sceurity;

import com.tfx0one.center.sys.model.SysUser;
import com.tfx0one.common.sceurity.impl.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.*;

/**
 * Created by 2fx0one on 2018/6/4.
 */
public class JWTUtils {

    private static String secret = "MmZ4MG9uZQ==";
    private static int expiredTimeOutSecond = 86400; //#token 过期时间修改为 1天后

//    {
//        Properties props = new Properties();
//        try {
//            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("security.properties"));
//            secret = props.getProperty("jwt.secret");
//            System.out.println("++++++ " + secret);
//            expiredTimeOutSecond = Integer.parseInt(props.getProperty("jwt.expiredTimeOutSecond"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiredTimeOutSecond}")
//    private int expiredTimeOutSecond;

    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_ROLES = "roles";
    private static final String KEY_ACCOUNT_TYPE = "account_type";


    public static String generateToken(Integer id, String username, List<String> roles) {
        Map<String, Object> data = new HashMap<>();
        data.put(KEY_ID, id);
        data.put(KEY_USERNAME, username);
        data.put(KEY_ROLES, roles);
        return generateToken(data, secret);
    }

    //过期时间 1天后
//    private Date generateExpirationDate() {
//        return new Date(System.currentTimeMillis() + expiredTimeOutSecond * 1000);
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, 1); //加一天。
//        calendar.set(Calendar.HOUR_OF_DAY, 4); //凌晨4点
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        return calendar.getTime(); //隔天的凌晨4点
//        return new Date(System.currentTimeMillis() + expiredTimeSecond*1000);
//    }

    private static String generateToken(Map<String, Object> claims, String secret) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiredTimeOutSecond * 1000)) //过期时间 1天后
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private static Claims getClaimsFromToken(String token, String secret) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private static String getValueFromToken(String authToken, String key) {
//        System.out.println("getUsernameFromToken() " + authToken);
        Claims claims = getClaimsFromToken(authToken, secret);

        return (null != claims) ? claims.get(key, String.class) : null;
    }

    public static String getUsernameFromToken(String token) {
        return getValueFromToken(token, KEY_USERNAME);
    }

    public static String getIdFromToken(String token) {
        return getValueFromToken(token, KEY_ID);
    }


    public static boolean validateToken(String authToken, UserDetailsImpl userDetails) {
        if (authToken == null || userDetails == null) {
            return false;
        }

//        if (getIdFromToken(authToken) == null || userDetails.getId() == null) {
//            return false;
//        }
//
//        //id必须一致
//        if (!getIdFromToken(authToken).equals(userDetails.getId())) {
//            return false;
//        }

        //TODO 验证需要完成更多逻辑
        return true;
    }

//    public String generateTokenThenCacheUser(UserDetailsImpl userDetails) {
//        Map<String, Object> data = new HashMap<>();
//        data.put(KEY_USERNAME, userDetails.getUsername());
//        data.put(KEY_ID, userDetails.getId());
//        return this.generateTokenThenCacheUser(data, this.secret, this.expiredTimeOutSecond);
//    }

}
