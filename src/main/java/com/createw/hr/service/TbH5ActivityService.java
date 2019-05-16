package com.createw.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.createw.hr.bean.TbH5Activity;
import com.createw.hr.bean.TbH5ActivityExample;

@Service(value="tbH5ActivityService")
public interface TbH5ActivityService {
	long countByExample(TbH5ActivityExample example);
	List<TbH5Activity> selectByExample(TbH5ActivityExample example);
	TbH5Activity selectByPrimaryKey(String id);
	int updateByPrimaryKeySelective(TbH5Activity tbH5Activity);
	int insertSelective(TbH5Activity tbH5Activity);
	int deleteByPrimaryKey(String id);
}
