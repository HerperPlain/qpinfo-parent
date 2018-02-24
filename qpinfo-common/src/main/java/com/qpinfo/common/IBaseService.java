package com.qpinfo.common;

import java.util.List;

/**
 * @author 黄朴（Herper.Plain）
 * @Date 2018/2/5 下午10:10
 * @Company 青朴信息技术服务有限公司
 */
public interface IBaseService<T,E,V> {
    /**
     *  新增
     * @param model
     * @return
     */
    public int insert(T model);

    /**
     * 保存
     * @param model
     * @return
     */
    public int save(T model);

    /**
     * 删除
     * @param example
     * @return
     */
    public int delete(E example);

    /**
     * 列表查询
     * @param example
     * @return
     */
    public List<V> list(E example);

    /**
     * 分页查询
     * @param example
     * @return
     */
    public List<V> queryPage(E example);

    /**
     * 查询
     * @param example
     * @return
     */
    public V query(E example);
}
