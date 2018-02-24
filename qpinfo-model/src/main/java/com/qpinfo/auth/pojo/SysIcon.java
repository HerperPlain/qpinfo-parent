package com.qpinfo.auth.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 黄朴（Herper.Plain)  
 * @studio 默云工作室 
 * @company 青朴信息技术服务有限公司
 * sys_icon
 * 2018-02-20
 */
public class SysIcon implements Serializable{
    /** 编号 (ID) */
    private Integer id;

    /** icon名称 */
    private String iconName;

    /** 样式编码 */
    private String iconCode;

    /** 样例 */
    private String demo;

    /** 备注 */
    private String remark;

    /** icon 状态： 1 开启 2 关闭 3 删除  (: 1) */
    private Integer state;

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

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName == null ? null : iconName.trim();
    }

    public String getIconCode() {
        return iconCode;
    }

    public void setIconCode(String iconCode) {
        this.iconCode = iconCode == null ? null : iconCode.trim();
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo == null ? null : demo.trim();
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
        return "SysIcon{" +
                "id=" + id +
                ", iconName='" + iconName + '\'' +
                ", iconCode='" + iconCode + '\'' +
                ", demo='" + demo + '\'' +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", createMan='" + createMan + '\'' +
                ", modifyTime=" + modifyTime +
                ", modifyMan='" + modifyMan + '\'' +
                '}';
    }
}