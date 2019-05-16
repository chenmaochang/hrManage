package com.createw.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.createw.hr.bean.Goods;
import com.createw.hr.bean.GoodsExample;

@Service(value="goodsService")
public interface GoodsService {
	long countByExample(GoodsExample example);
	List<Goods> selectByExample(GoodsExample example);
	Integer insert(Goods goods);
	int insertSelective(Goods record);
	int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);
}
