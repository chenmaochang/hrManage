package com.createw.hr.controller.api;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.createw.hr.bean.Goods;
import com.createw.hr.bean.GoodsExample;
import com.createw.hr.service.GoodsService;

@RequestMapping("/api/goods")
@RestController
public class GoodsApi {
    static final Logger LOGGER = LoggerFactory.getLogger(GoodsApi.class);
    @Resource
    GoodsService goodsService;

    /**接口名称:获取服务商品列表
     * 接口地址:ip:port/项目名/api/goods/list
     *2019年5月14日 下午4:35:51
     * 作者 陈茂昌
     * email:chenmc@createw.com
     * @param belongCategory *选填 所属分类 (中文)
     * @param goodsName *选填 商品标题
     * @param page 第几页
     * @param limit 每页多少
     * @return
     * {
    "code": 0,
    "data": [
        {
            "id": "D0FBC9E9231D4869A0C41ECD6C9114CA",
            (商品名称)"goodsName": "阿斯顿飞噶三代富贵1122",
            (商品价格)"goodsPrice": null,
            (商品主图)"mainPicture": "http://yxrh.createt.cn:8091/upload/0875766e-fbb0-4240-a97e-30da6c6083ea.jpg,http://yxrh.createt.cn:8091/upload/0875766e-fbb0-4240-a97e-30da6c6083ea.jpg",
            (请求参数json)"requestParam": [{"pname":"这是名字123","ptype":"这是类型123","pmust":"这是必填123","pdesc":"这是描述123"},{"pname":"123","ptype":"345","pmust":"adfg","pdesc":"adfg"}],
            (返回参数json)"responseParam": [{"pname":"这是名字1234","ptype":"这是类型1234","pdesc":"这是描述1234","LAY_TABLE_INDEX":0}],
            (返回示例)"responseSample": "阿斯顿飞阿斯顿法国",
            (上架状态 0待上架 1出售中)"pendStatus": "1",
            (创建时间)"createTime": "2019-05-14 11:22:16",
            (修改时间)"updateTime": "2019-05-14 11:22:16",
            (创建者id)"createId": null,
            (修改者id)"updateId": null,
            (系统状态 0已删  1正常)"sysStatus": "1",
            (所属类型)"belongCategory": "金融征信"
        }
    ],
    "count": 1
}
     */
    @PostMapping("/list")
    public JSONObject list(@ModelAttribute("goods")Goods goods,@RequestParam(value="page",defaultValue="1") Integer page,@RequestParam(value="limit",defaultValue="10") Integer limit) {
    	JSONObject jsonObject=new JSONObject();
    	GoodsExample goodsExample=new GoodsExample();
    	GoodsExample.Criteria criteria=goodsExample.createCriteria();
    	if(StringUtils.isNotBlank(goods.getGoodsName())){
    		criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
    	}
    	if(StringUtils.isNotBlank(goods.getBelongCategory())) {
    		criteria.andBelongCategoryEqualTo(goods.getBelongCategory());
    	}
    	if(goods.getGoodsPrice()!=null&&goods.getGoodsPrice()==0) {
    		criteria.andGoodsPriceEqualTo(0);
    	}
    	goodsExample.setOrderByClause("create_time desc");
    	criteria.andSysStatusEqualTo("1");
    	criteria.andPendStatusEqualTo("1");
    	jsonObject.put("count", goodsService.countByExample(goodsExample));
    	
    	goodsExample.setLimit("limit "+(page-1)*limit+","+limit);
    	List<Goods> goodses=goodsService.selectByExample(goodsExample);
    	jsonObject.put("data", goodses);
    	jsonObject.put("code", 0);
    	return jsonObject;
    }
    
    /**接口名字:获取单个商品服务
     * 接口地址:ip:port/项目名/api/goods/get/{id}
     * 注意,!!restful风格接口,使用get请求,id动态拼接在url后 如  localhost:8080/api/goods/get/D0FBC9E9231D4869A0C41ECD6C9114CA
     * 
     *2019年5月14日 下午4:59:47
     * 作者 陈茂昌
     * email:chenmc@createw.com
     * @return
     * {
    "success": true,
    "goods": {
            "id": "D0FBC9E9231D4869A0C41ECD6C9114CA",
            (商品名称)"goodsName": "阿斯顿飞噶三代富贵1122",
            (商品价格)"goodsPrice": null,
            (商品主图)"mainPicture": "http://yxrh.createt.cn:8091/upload/0875766e-fbb0-4240-a97e-30da6c6083ea.jpg,http://yxrh.createt.cn:8091/upload/0875766e-fbb0-4240-a97e-30da6c6083ea.jpg",
            (请求参数json)"requestParam": [{"pname":"这是名字123","ptype":"这是类型123","pmust":"这是必填123","pdesc":"这是描述123"},{"pname":"123","ptype":"345","pmust":"adfg","pdesc":"adfg"}],
            (返回参数json)"responseParam": [{"pname":"这是名字1234","ptype":"这是类型1234","pdesc":"这是描述1234","LAY_TABLE_INDEX":0}],
            (返回示例)"responseSample": "阿斯顿飞阿斯顿法国",
            (上架状态 0待上架 1出售中)"pendStatus": "1",
            (创建时间)"createTime": "2019-05-14 11:22:16",
            (修改时间)"updateTime": "2019-05-14 11:22:16",
            (创建者id)"createId": null,
            (修改者id)"updateId": null,
            (系统状态 0已删  1正常)"sysStatus": "1",
            (所属类型)"belongCategory": "金融征信"
        }
}
     */
    @GetMapping("/get/{id}")
    public JSONObject get(@PathVariable("id")String id) {
    	JSONObject rtnObj=new JSONObject();
    	GoodsExample goodsExample=new GoodsExample();
    	GoodsExample.Criteria criteria=goodsExample.createCriteria();
    	criteria.andIdEqualTo(id);
    	List<Goods> goods=goodsService.selectByExample(goodsExample);
    	if(goods.size()<=0) {
    		rtnObj.put("success", false);
    		return rtnObj;
    	}
    	rtnObj.put("success", true);
    	rtnObj.put("goods", goods.get(0));
    	return rtnObj;
    }
}
