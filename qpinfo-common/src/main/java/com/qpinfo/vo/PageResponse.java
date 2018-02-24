package com.qpinfo.vo;

import com.qpinfo.enums.ResponseEnum;

import java.io.Serializable;

/**
 * @author 黄朴（Herper.Plain）
 * @Date 2018/1/30 下午2:27
 */
public class PageResponse implements Serializable {
    private int code;
    private String msg;
    private int count;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public PageResponse code(int code){
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public PageResponse msg(String msg){
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public PageResponse data(Object data){
        this.data = data;
        return this;
    }
    public PageResponse count(int count){
        this.count = count;
        return this;
    }
    public PageResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public PageResponse(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMessage();
    }
    public PageResponse() {
    }

    public PageResponse(int code, String msg, int count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
