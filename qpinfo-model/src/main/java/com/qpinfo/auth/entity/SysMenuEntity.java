package com.qpinfo.auth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 黄朴（Herper.Plain）
 * @Date 2018/2/4 下午7:33
 * @Company 青朴信息技术服务有限公司
 */
@Entity
@Table(name = "sys_menu")
public class SysMenuEntity implements Serializable{
    /** 菜单id */
    private String menuId;

    /** 菜单名称 */
    private String menuName;

    /** 父级ID */
    @Column(name = "parent_id")
    private String parentId;

    /** 简介 */
    @Column(name = "brief")
    private String brief;

    /** 备注 */
    @Column(name = "remark")
    private String remark;

    @Id
    @Column(name = "meun_id",columnDefinition = " varchar(32) COMMENT '菜单编号'")
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Column(name = "meun_name",columnDefinition = " varchar(200) COMMENT '菜单名称'")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Column(name = "meun_name",columnDefinition = " varchar(200) COMMENT '菜单名称'")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
