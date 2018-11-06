package com.tfx0one.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by 2fx0one on 2018/7/17.
 */
public class RandomSerialNumberUtils {
//流水号生成器 当前时间 + 6 位随机数
    private static Random random = new Random(System.currentTimeMillis());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String generateSerialNo() {
        return dateFormat.format(new Date()) + String.valueOf(random.nextInt(900000)+100000);
    }
}
