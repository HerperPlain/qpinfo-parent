package com.qpinfo.vo;

import java.io.Serializable;

/**
 * @author 黄朴（Herper.Plain）
 * @Date 2018/2/5 下午10:30
 * @Company 青朴信息技术服务有限公司
 */
public class Request implements Serializable {
    private int page;
    private int pageSize;
    private String token;
    private String id;
    private String version;
    private int queryType;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getQueryType() {
        return queryType;
    }

    public void setQueryType(int queryType) {
        this.queryType = queryType;
    }

    @Override
    public String toString() {
        return "Request{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", token='" + token + '\'' +
                ", id='" + id + '\'' +
                ", version='" + version + '\'' +
                ", queryType=" + queryType +
                '}';
    }
}
