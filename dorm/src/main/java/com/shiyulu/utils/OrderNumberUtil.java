package com.shiyulu.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class OrderNumberUtil {
/**
     * 生成短订单号
     * @return 短订单号
 */
    public static String generateShortOrderNumber() throws NoSuchAlgorithmException {
        // 生成 UUID
        String uuid = UUID.randomUUID().toString();
        // 获取 MD5 哈希值
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] hash = md5.digest(uuid.getBytes());
        // 将哈希值转换为十六进制字符串
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString().substring(0, 10);
//        return hexString.toString();
    }
}
