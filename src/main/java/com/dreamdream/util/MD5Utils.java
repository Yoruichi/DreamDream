package com.dreamdream.util;

import java.security.MessageDigest;

public class MD5Utils {

    public final static String getPassword(String password) {
        return MD5Utils.MD5(password + MD5Utils.MD5(password));
    }
    
    public final static String MD5(String s) {
        char hexDigits[] =
                {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long getMD5Sum(String text) {
        long sum = 0l;
        String tmp = MD5(text);
        System.out.println(tmp);
        if (tmp != null)
            for (char b : tmp.toCharArray()) {
                sum += b;
            }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getMD5Sum("SAA00000001") % 10);
        System.out.println(getMD5Sum("SAA00000002") % 10);
        System.out.println(getMD5Sum("SAA00000003") % 10);
        System.out.println(getMD5Sum("SAA00000004") % 10);
        System.out.println(getMD5Sum("SAA00000005") % 10);
        System.out.println(getMD5Sum("SAA00000006") % 10);
        System.out.println(getMD5Sum("SAA00000007") % 10);
        System.out.println(getMD5Sum("SAA00000008") % 10);
        System.out.println(getMD5Sum("SAA00000009") % 10);
        System.out.println(getMD5Sum("SAA00000010") % 10);
    }
}