package com.werner.ping.controller.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 童平平
 * @Title: ssmTest02
 * @Package com.werner.ping.controller.converter
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.07 20:58
 */

/**
 * S-source:源
 * T-target:目标
 *
 */
public class CustomGlobalStrToDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(s);
            return  date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
