package com.createw.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.createw.hr.bean.TKnowledge;
import com.createw.hr.bean.TKnowledgeExample;

public interface TKnowledgeMapper {
    long countByExample(TKnowledgeExample example);

    int deleteByExample(TKnowledgeExample example);

    int deleteByPrimaryKey(String id);

    int insert(TKnowledge record);

    int insertSelective(TKnowledge record);

    List<TKnowledge> selectByExampleWithBLOBsWithRowbounds(TKnowledgeExample example, RowBounds rowBounds);

    List<TKnowledge> selectByExampleWithBLOBs(TKnowledgeExample example);

    List<TKnowledge> selectByExampleWithRowbounds(TKnowledgeExample example, RowBounds rowBounds);

    List<TKnowledge> selectByExample(TKnowledgeExample example);

    TKnowledge selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TKnowledge record, @Param("example") TKnowledgeExample example);

    int updateByExampleWithBLOBs(@Param("record") TKnowledge record, @Param("example") TKnowledgeExample example);

    int updateByExample(@Param("record") TKnowledge record, @Param("example") TKnowledgeExample example);

    int updateByPrimaryKeySelective(TKnowledge record);

    int updateByPrimaryKeyWithBLOBs(TKnowledge record);

    int updateByPrimaryKey(TKnowledge record);
}