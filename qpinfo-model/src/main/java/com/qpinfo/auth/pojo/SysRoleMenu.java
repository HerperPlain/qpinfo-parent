package com.qpinfo.auth.pojo;

import java.io.Serializable;

/**
 * @author 黄朴（Herper.Plain)  
 * @studio 默云工作室 
 * @company 默云网络科技有限公司 
 * @table sys_role_menu
 * @Date 2018-02-28
 */
public class SysRoleMenu implements Serializable {
    /** 角色id */
    private Integer roleId;

    /** 菜单id */
    private Integer menuId;

    private static final long serialVersionUID = 1L;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}