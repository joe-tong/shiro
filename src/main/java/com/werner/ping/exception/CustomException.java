package com.werner.ping.exception;

/**
 * @author 童平平
 * @Title: ssmTest02
 * @Package com.werner.ping.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.08 14:46
 */

public class CustomException extends Exception {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5212079010855161498L;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    //异常信息
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}