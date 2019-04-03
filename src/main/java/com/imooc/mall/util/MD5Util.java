package com.imooc.mall.util;

import java.security.MessageDigest;

/**
 * @author 宋艾衡
 * @date 2019-04-03 23:08
 */
public class MD5Util {

    private static String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};


    private static String byteArrayToHexString(byte b[]){
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0;i< b.length;i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b){
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n/16;
        int d2 = n%16;
        return hexDigits[d1] + hexDigits[d2];
    }

    private static String MD5Encoding(String origin, String charsetname) {
        String resultString = null;
        try {

            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception e) {
        }
        return resultString.toUpperCase();
    }

    public static final String MD5EncodingUtf8(String origin){
        origin = origin + PropertiesUtil.getProperty("password.salt", "");
        return MD5Encoding(origin, "utf-8");
    }


}
