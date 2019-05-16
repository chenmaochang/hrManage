package com.createw.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.createw.hr.bean.TKnowledge;
import com.createw.hr.bean.TKnowledgeExample;

@Service(value="tKnowledgeCategoryService")
public interface TKnowledgeService {
	long countByExample(TKnowledgeExample example);
	List<TKnowledge> selectByExample(TKnowledgeExample example);
	TKnowledge selectByPrimaryKey(String id);
	int updateByPrimaryKeySelective(TKnowledge tKnowledge);
	int insertSelective(TKnowledge tKnowledge);
	int deleteByPrimaryKey(String id);
}
