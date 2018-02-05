package com.qpinfo.auth.pojo;

/**
 * @author 黄朴（Herper.Plain)  
 * @studio 默云工作室 
 * @company 青朴信息技术服务又想公司 
 * sys_menu
 * 2018-02-05
 */
public class SysMenu {
    /** 菜单编号 (ID) */
    private String meunId;

    /**  (ID) */
    private String id;

    /**  */
    private String brief;

    /** 菜单名称 */
    private String meunName;

    /**  */
    private String parentId;

    /**  */
    private String remark;

    public String getMeunId() {
        return meunId;
    }

    public void setMeunId(String meunId) {
        this.meunId = meunId == null ? null : meunId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getMeunName() {
        return meunName;
    }

    public void setMeunName(String meunName) {
        this.meunName = meunName == null ? null : meunName.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}