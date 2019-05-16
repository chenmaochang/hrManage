package com.createw.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.createw.hr.bean.TKnowledgeCategory;
import com.createw.hr.bean.TKnowledgeCategoryExample;

@Service(value="tKnowledgeCategoryService")
public interface TKnowledgeCategoryService {
	long countByExample(TKnowledgeCategoryExample example);
	List<TKnowledgeCategory> selectByExample(TKnowledgeCategoryExample example);
	TKnowledgeCategory selectByPrimaryKey(String id);
	int updateByPrimaryKeySelective(TKnowledgeCategory tKnowledgeCategory);
	int insertSelective(TKnowledgeCategory tKnowledgeCategory);
	int deleteByPrimaryKey(String categoryId);
}
