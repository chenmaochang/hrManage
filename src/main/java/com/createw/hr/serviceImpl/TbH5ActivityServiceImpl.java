package com.createw.hr.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createw.hr.bean.TbH5Activity;
import com.createw.hr.bean.TbH5ActivityExample;
import com.createw.hr.mapper.TbH5ActivityMapper;
import com.createw.hr.service.TbH5ActivityService;

@Service
public class TbH5ActivityServiceImpl implements TbH5ActivityService{

	@Autowired
	private TbH5ActivityMapper tbH5ActivityMapper;
	@Override
	public long countByExample(TbH5ActivityExample example) {
		return tbH5ActivityMapper.countByExample(example);
	}
	@Override
	public List<TbH5Activity> selectByExample(TbH5ActivityExample example) {
		return tbH5ActivityMapper.selectByExample(example);
	}
	@Override
	public TbH5Activity selectByPrimaryKey(String id) {
		return tbH5ActivityMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateByPrimaryKeySelective(TbH5Activity tbH5Activity) {
		return tbH5ActivityMapper.updateByPrimaryKeySelective(tbH5Activity);
	}
	@Override
	public int insertSelective(TbH5Activity tbH5Activity) {
		return tbH5ActivityMapper.insertSelective(tbH5Activity);
	}
	@Override
	public int deleteByPrimaryKey(String id) {
		return tbH5ActivityMapper.deleteByPrimaryKey(id);
	}

}
