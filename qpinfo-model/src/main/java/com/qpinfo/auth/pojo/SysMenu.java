package com.qpinfo.auth.pojo;

import java.util.Date;

/**
 * @author 黄朴（Herper.Plain)  
 * @studio 默云工作室 
 * @company 青朴信息技术服务又想公司 
 * sys_menu
 * 2018-02-23
 */
public class SysMenu {
    /** 自增主键 (ID) */
    private Integer id;

    /** 菜单名称 */
    private String title;

    /** 父节点 */
    private Integer parentId;

    /** 菜单图标 */
    private String icon;

    /** 跳转url */
    private String href;

    /** 状态：1默认可用  (: 1) */
    private Integer state;

    /** 备注 */
    private String remark;

    /** 菜单等级，1：一级菜单，2：二级菜单，3：三级菜单 */
    private Integer level;

    /** 创建日期 */
    private Date createTime;

    /** 创建人 */
    private String createMan;

    /** 修改日期 */
    private Date modifyTime;

    /** 修改人 */
    private String modifyMan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan == null ? null : createMan.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyMan() {
        return modifyMan;
    }

    public void setModifyMan(String modifyMan) {
        this.modifyMan = modifyMan == null ? null : modifyMan.trim();
    }
}