package com.werner.ping;

import com.werner.ping.util.CryptographyUtil;

/**
 * @author 童平平
 * @Title: shiro
 * @Package com.werner.ping
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.25 19:39
 */
public class EncCodeTest {
    public static void main(String[] args) {
        String password = "123456";
        System.out.println("Base64加密:"+ CryptographyUtil.encBase64(password));
        System.out.println("Base64解密:"+ CryptographyUtil.decBase64(CryptographyUtil.encBase64(password)));
        System.out.println("MD5加密:"+CryptographyUtil.md5(password,"java1234"));
    }
}
