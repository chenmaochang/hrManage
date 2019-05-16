package com.createw.hr.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createw.hr.bean.TKnowledgeCategory;
import com.createw.hr.bean.TKnowledgeCategoryExample;
import com.createw.hr.mapper.TKnowledgeCategoryMapper;
import com.createw.hr.service.TKnowledgeCategoryService;

@Service
public class TKnowledgeCategoryServiceImpl implements TKnowledgeCategoryService{

	@Autowired
	private TKnowledgeCategoryMapper tKnowledgeCategoryMapper;
	@Override
	public long countByExample(TKnowledgeCategoryExample example) {
		return tKnowledgeCategoryMapper.countByExample(example);
	}
	@Override
	public List<TKnowledgeCategory> selectByExample(TKnowledgeCategoryExample example) {
		return tKnowledgeCategoryMapper.selectByExample(example);
	}
	@Override
	public TKnowledgeCategory selectByPrimaryKey(String id) {
		return tKnowledgeCategoryMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateByPrimaryKeySelective(TKnowledgeCategory tKnowledgeCategory) {
		return tKnowledgeCategoryMapper.updateByPrimaryKeySelective(tKnowledgeCategory);
	}
	@Override
	public int insertSelective(TKnowledgeCategory tKnowledgeCategory) {
		return tKnowledgeCategoryMapper.insertSelective(tKnowledgeCategory);
	}
	@Override
	public int deleteByPrimaryKey(String categoryId) {
		return tKnowledgeCategoryMapper.deleteByPrimaryKey(categoryId);
	}

}
