package com.qpinfo.auth.dao;

import com.qpinfo.auth.pojo.SysIcon;
import com.qpinfo.auth.pojo.SysIconExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysIconMapper {
    long countByExample(SysIconExample example);

    int deleteByExample(SysIconExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysIcon record);

    int insertSelective(SysIcon record);

    List<SysIcon> selectByExample(SysIconExample example);

    SysIcon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysIcon record, @Param("example") SysIconExample example);

    int updateByExample(@Param("record") SysIcon record, @Param("example") SysIconExample example);

    int updateByPrimaryKeySelective(SysIcon record);

    int updateByPrimaryKey(SysIcon record);
}