package com.createw.hr.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createw.hr.bean.Goods;
import com.createw.hr.bean.GoodsExample;
import com.createw.hr.mapper.GoodsMapper;
import com.createw.hr.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper goodsMapper;
	@Override
	public long countByExample(GoodsExample example) {
		return goodsMapper.countByExample(example);
	}
	@Override
	public List<Goods> selectByExample(GoodsExample example) {
		return goodsMapper.selectByExample(example);
	}
	@Override
	public Integer insert(Goods goods) {
		return goodsMapper.insert(goods);
	}
	@Override
	public int updateByExampleSelective(Goods record, GoodsExample example) {
		return goodsMapper.updateByExampleSelective(record, example);
	}
	@Override
	public int insertSelective(Goods record) {
		return goodsMapper.insertSelective(record);
	}
	

}
