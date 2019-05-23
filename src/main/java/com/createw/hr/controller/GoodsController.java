package com.createw.hr.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.createw.hr.bean.Goods;
import com.createw.hr.bean.GoodsExample;
import com.createw.hr.bean.GoodsExample.Criteria;
import com.createw.hr.service.GoodsService;

/**
 * 百科分类controller
 * @author 陈茂昌 2018年9月21日 下午4:11:40
 * @mail chenmc@createw.com
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);
    static final String VIEW="goods";
    @Resource
    GoodsService goodsService;
    
    /**
     * 打开分类数据列表页面
     * @author 陈茂昌 2018年9月21日 下午4:11:31
     * @mail chenmc@createw.com
     * @return
     */
    @RequestMapping("/goodsList")
    public ModelAndView categoryList(){
    	/*GoodsExample goodsExample=new GoodsExample();
    	Criteria criteria=goodsExample.createCriteria();
    	criteria.andSysStatusEqualTo("0");
    	List<Goods> goods=goodsService.selectByExample(goodsExample);*/
        return new ModelAndView(VIEW+"/goodsList");
    }
    
    /**
     * 返回数据
     * @author 陈茂昌 2018年9月21日 下午4:11:38
     * @mail chenmc@createw.com
     * @param goodsCategory
     * @return
     */
    @RequestMapping("/listData")
    @ResponseBody
    public JSONObject listData(@ModelAttribute("goods") Goods goods,@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
    	JSONObject jsonObject=new JSONObject();
    	GoodsExample goodsExample=new GoodsExample();
    	GoodsExample.Criteria criteria=goodsExample.createCriteria();
    	if(StringUtils.isNotBlank(goods.getGoodsName())){
    		criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
    	}
    	if(StringUtils.isNotBlank(goods.getPendStatus())){
    		criteria.andPendStatusEqualTo(goods.getPendStatus());
    	}
    	if(StringUtils.isNotBlank(goods.getBelongCategory())) {
    		criteria.andBelongCategoryEqualTo(goods.getBelongCategory());
    	}
    	
    	goodsExample.setOrderByClause("create_time desc");
    	criteria.andSysStatusEqualTo("1");
    	jsonObject.put("count", goodsService.countByExample(goodsExample));
    	
    	goodsExample.setLimit("limit "+(page-1)*limit+","+limit);
    	List<Goods> goodses=goodsService.selectByExampleWithBLOBs(goodsExample);
    	jsonObject.put("data", goodses);
    	jsonObject.put("code", 0);
    	return jsonObject;
    }
    
    /**
     * 新增数据
     * @author 陈茂昌 2018年9月21日 下午4:11:33
     * @mail chenmc@createw.com
     * @param goodsCategory
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(@ModelAttribute("goods") Goods goods){
    	JSONObject rtnObj=new JSONObject();
    	try {
    		if(StringUtils.isBlank(goods.getId())){
        		String uuid=UUID.randomUUID().toString().replace("-", "").toUpperCase();
            	goods.setId(uuid);
            	goodsService.insertSelective(goods);
        	}else{
        		GoodsExample example=new GoodsExample();
        		Criteria criteria=example.createCriteria();
        		criteria.andIdEqualTo(goods.getId());
        		goodsService.updateByExampleSelective(goods, example);
        	}
        	rtnObj.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			rtnObj.put("success", false);
		}
    	return rtnObj;
    }
    
    /**
     * 打开创建分类页面
     * @author 陈茂昌 2018年9月21日 下午4:11:28
     * @mail chenmc@createw.com
     * @param categoryId
     * @return
     */
	@RequestMapping("/create")
	public ModelAndView create(@RequestParam("id")String id) {
		Goods goods=new Goods();
		ModelAndView modelAndView = new ModelAndView(VIEW + "/goodsCreate");
		if(StringUtils.isNotBlank(id)){
			GoodsExample example=new GoodsExample();
			Criteria criteria=example.createCriteria();
			criteria.andIdEqualTo(id);
			List<Goods> list=goodsService.selectByExampleWithBLOBs(example);
			if(list.size()>0) {
				goods=list.get(0);
			}
			modelAndView.addObject("view", "edit");
		}else {
			goods.setRequestParam("[]");
			goods.setResponseParam("[]");
			goods.setMainPicture("");
			modelAndView.addObject("view", "create");
		}
		modelAndView.addObject("goods", goods);
		return modelAndView;
	}
	
    /**
     *删除操作
	*@authod 陈茂昌 2018年9月21日 下午4:11:22
	*@mail chenmaochang@createw.com
	*@param request
	*@param response
	*@retuen rtnObj
	*/
	@RequestMapping("delete")
	@ResponseBody
	public JSONObject delete(@RequestParam("id")String id) {
		JSONObject rtnObj = new JSONObject();//use to return
		try {
			GoodsExample example=new GoodsExample();
			Criteria criteria=example.createCriteria();
			criteria.andIdEqualTo(id);
			Goods goods=new Goods();
			goods.setId(id);
			goods.setSysStatus("0");
			goodsService.updateByExampleSelective(goods, example);
			rtnObj.put("success", true);
		} catch (Exception e) {
			rtnObj.put("success", false);
		}
		return rtnObj;
	}
	
    /**
     * 打开创建分类页面
     * @author 陈茂昌 2018年9月21日 下午4:11:28
     * @mail chenmc@createw.com
     * @param categoryId
     * @return
     */
	@RequestMapping("/get")
	public ModelAndView get(@RequestParam("id")String id) {
		GoodsExample example=new GoodsExample();
		Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(id);
		List<Goods> list=goodsService.selectByExampleWithBLOBs(example);
		ModelAndView modelAndView = new ModelAndView(VIEW + "/goodsCreate");
		modelAndView.addObject("goods", list.get(0));
		modelAndView.addObject("view", "get");
		return modelAndView;
	}
	
	/**上下架操作
	 *2019年5月14日 下午2:20:35
	 * 作者 陈茂昌
	 * email:chenmc@createw.com
	 * @param goods
	 * @return
	 */
	@PostMapping("/pend")
	public JSONObject pend(@ModelAttribute("goods")Goods goods) {
		JSONObject rtnObj=new JSONObject();
		try {
			GoodsExample example=new GoodsExample();
			Criteria criteria=example.createCriteria();
			criteria.andIdEqualTo(goods.getId());
			goodsService.updateByExampleSelective(goods, example);
			rtnObj.put("success", true);
		} catch (Exception e) {
			rtnObj.put("success", false);
		}
		return rtnObj;
	}
	
	
	/**批量操作
	 *2019年5月14日 下午3:28:54
	 * 作者 陈茂昌
	 * email:chenmc@createw.com
	 * @param ids
	 * @param operate
	 * @return
	 */
	@PostMapping("/batchOperate")
	public JSONObject batchOperate(String ids,String operate) {
		JSONObject rtnObj=new JSONObject();
		try {
			List<String> idList=JSONArray.parseArray(ids, String.class);
			Goods record=new Goods();
			if(operate.equals("1")) {//上架
				record.setPendStatus("1");
			}else if(operate.equals("2")) {//下架
				record.setPendStatus("0");
			}else if(operate.equals("3")) {//删除
				record.setSysStatus("0");
			}
			GoodsExample example=new GoodsExample();
			Criteria criteria=example.createCriteria();
			criteria.andIdIn(idList);
			goodsService.updateByExampleSelective(record, example);
			rtnObj.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			rtnObj.put("success", false);
		}
		return rtnObj;
	}
    
}
