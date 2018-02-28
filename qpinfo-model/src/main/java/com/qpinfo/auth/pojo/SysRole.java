package com.qpinfo.auth.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 黄朴（Herper.Plain)  
 * @studio 默云工作室 
 * @company 默云网络科技有限公司 
 * @table sys_role
 * @Date 2018-02-28
 */
public class SysRole implements Serializable {
    /**  (ID) */
    private Integer id;

    /** 角色名称 */
    private String roleName;

    /** 角色编码 */
    private String roleCode;

    /** 备注 */
    private String remark;

    /** icon 状态： 1 开启 2 关闭 3 删除 */
    private Integer state;

    /** 创建日期 */
    private Date createTime;

    /** 创建人 */
    private String createMan;

    /** 修改日期 */
    private Date modifyTime;

    /** 修改人 */
    private String modifyMan;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", createMan='" + createMan + '\'' +
                ", modifyTime=" + modifyTime +
                ", modifyMan='" + modifyMan + '\'' +
                '}';
    }
}