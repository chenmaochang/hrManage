package com.createw.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.createw.hr.bean.TbH5Activity;
import com.createw.hr.bean.TbH5ActivityExample;

public interface TbH5ActivityMapper {
    long countByExample(TbH5ActivityExample example);

    int deleteByExample(TbH5ActivityExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbH5Activity record);

    int insertSelective(TbH5Activity record);

    List<TbH5Activity> selectByExampleWithRowbounds(TbH5ActivityExample example, RowBounds rowBounds);

    List<TbH5Activity> selectByExample(TbH5ActivityExample example);

    TbH5Activity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbH5Activity record, @Param("example") TbH5ActivityExample example);

    int updateByExample(@Param("record") TbH5Activity record, @Param("example") TbH5ActivityExample example);

    int updateByPrimaryKeySelective(TbH5Activity record);

    int updateByPrimaryKey(TbH5Activity record);
}