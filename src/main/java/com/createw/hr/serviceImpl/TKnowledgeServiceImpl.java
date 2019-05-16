package com.createw.hr.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createw.hr.bean.TKnowledge;
import com.createw.hr.bean.TKnowledgeExample;
import com.createw.hr.mapper.TKnowledgeMapper;
import com.createw.hr.service.TKnowledgeService;

@Service
public class TKnowledgeServiceImpl implements TKnowledgeService{

	@Autowired
	private TKnowledgeMapper tKnowledgeMapper;
	@Override
	public long countByExample(TKnowledgeExample example) {
		return tKnowledgeMapper.countByExample(example);
	}
	@Override
	public List<TKnowledge> selectByExample(TKnowledgeExample example) {
		return tKnowledgeMapper.selectByExample(example);
	}
	@Override
	public TKnowledge selectByPrimaryKey(String id) {
		return tKnowledgeMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateByPrimaryKeySelective(TKnowledge tKnowledge) {
		return tKnowledgeMapper.updateByPrimaryKeySelective(tKnowledge);
	}
	@Override
	public int insertSelective(TKnowledge tKnowledge) {
		return tKnowledgeMapper.insertSelective(tKnowledge);
	}
	@Override
	public int deleteByPrimaryKey(String categoryId) {
		return tKnowledgeMapper.deleteByPrimaryKey(categoryId);
	}

}
