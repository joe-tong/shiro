package com.werner.ping.util;


import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author 童平平
 * @Title: shiro
 * @Package com.werner.ping.util
 * @Description: Base64是对称的
 * @date 2017.11.25 19:36
 */
public class CryptographyUtil {
    /**
     * base64加密
     */
    public static String encBase64(String str){
        return Base64.encodeToString(str.getBytes());
    }

    /**
     * base64解密
     * @param str
     * @return
     */
    public static String decBase64(String str){
        return Base64.decodeToString(str);
    }

    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString();
    }
}
