package com.tfx0one;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @projectName:jxxy-eShop
 * @author:wangk
 * @date:2018/11/7 11:19
 * @Version: 1.0
 */
public class TEST {
    public static void main(String[] args) {
        System.out.print(new BCryptPasswordEncoder().encode("123456"));
    }
}
