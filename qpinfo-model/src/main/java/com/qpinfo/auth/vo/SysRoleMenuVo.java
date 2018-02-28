package com.qpinfo.auth.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author 黄朴（Herper.Plain）
 * @date 2018/2/28 下午9:01
 * @studio 默云工作室
 * @company 默云网络科技有限公司
 * @project qpinfo-parent
 * @package com.qpinfo.auth.vo
 */
public class SysRoleMenuVo implements Serializable{
    private String title;
    private String value;
    private boolean checked = false;
    private boolean disabled = false;
    private List<SysRoleMenuVo> data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public List<SysRoleMenuVo> getData() {
        return data;
    }

    public void setData(List<SysRoleMenuVo> data) {
        this.data = data;
    }

    public SysRoleMenuVo() {
    }

    public SysRoleMenuVo(String title, String value, boolean checked, boolean disabled, List<SysRoleMenuVo> data) {
        this.title = title;
        this.value = value;
        this.checked = checked;
        this.disabled = disabled;
        this.data = data;
    }

    @Override
    public String toString() {
        return "SysRoleMenuVo{" +
                "title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", checked=" + checked +
                ", disabled=" + disabled +
                ", data=" + data +
                '}';
    }
}
