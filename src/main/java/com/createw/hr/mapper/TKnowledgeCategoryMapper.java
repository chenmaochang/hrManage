package com.createw.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.createw.hr.bean.TKnowledgeCategory;
import com.createw.hr.bean.TKnowledgeCategoryExample;

public interface TKnowledgeCategoryMapper {
    long countByExample(TKnowledgeCategoryExample example);

    int deleteByExample(TKnowledgeCategoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(TKnowledgeCategory record);

    int insertSelective(TKnowledgeCategory record);

    List<TKnowledgeCategory> selectByExampleWithRowbounds(TKnowledgeCategoryExample example, RowBounds rowBounds);

    List<TKnowledgeCategory> selectByExample(TKnowledgeCategoryExample example);

    TKnowledgeCategory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TKnowledgeCategory record, @Param("example") TKnowledgeCategoryExample example);

    int updateByExample(@Param("record") TKnowledgeCategory record, @Param("example") TKnowledgeCategoryExample example);

    int updateByPrimaryKeySelective(TKnowledgeCategory record);

    int updateByPrimaryKey(TKnowledgeCategory record);
}