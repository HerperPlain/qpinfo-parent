package com.qpinfo.vo;

import com.qpinfo.enums.ResponseEnum;

import java.io.Serializable;

/**
 * @author 黄朴（Herper.Plain）
 * @Date 2018/1/30 下午2:27
 */
public class Response implements Serializable {
    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Response code(int code){
        this.code = code;
        return this;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response message(String message){
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public Response data(Object data){
        this.data = data;
        return this;
    }

    public Response(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Response(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }
    public Response() {
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
