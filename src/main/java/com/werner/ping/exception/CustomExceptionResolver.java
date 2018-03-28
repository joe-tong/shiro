package com.werner.ping.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 童平平
 * @Title: ssmTest02
 * @Package com.werner.ping.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.08 14:48
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
        //发生异常的地方Service层 方法 包名+类名+方法名(参数)的字符串{ handler就是这些字符串}
        //日志1.发布Tomcat war Eclipese 2.发布Tomcat 服务器linux, Linux的控制台无法显示错误,只能打印日志
        ex.printStackTrace();
        CustomException customException = null;
        ModelAndView modelAndView = new ModelAndView();
        //如果抛出的是系统自定义异常则直接转换
        if (ex instanceof CustomException) {
            customException = (CustomException) ex;
             modelAndView.addObject("message", customException.getMessage());
        } else {
            //如果抛出的不是系统自定义异常则重新构造一个系统错误异常。
            modelAndView.addObject("message", "未知异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }

}