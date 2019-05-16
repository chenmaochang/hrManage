package com.createw.hr.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.createw.hr.bean.TKnowledge;
import com.createw.hr.bean.TKnowledgeCategory;
import com.createw.hr.bean.TKnowledgeCategoryExample;
import com.createw.hr.bean.TKnowledgeExample;
import com.createw.hr.service.TKnowledgeCategoryService;
import com.createw.hr.service.TKnowledgeService;

/**
 * 百科分类controller
 * @author 陈茂昌 2018年9月21日 下午4:11:40
 * @mail chenmc@createw.com
 */
@RestController
@RequestMapping("/tKnowledge")
public class TKnowledgeController {
    static final Logger LOGGER = LoggerFactory.getLogger(TKnowledgeController.class);
    static final String view="tKnowledge";
    @Resource
    TKnowledgeService tKnowledgeService;
    @Resource
    TKnowledgeCategoryService tKnowledgeCategoryService;
    
    /**
     * 打开分类数据列表页面
     * @author 陈茂昌 2018年9月21日 下午4:11:31
     * @mail chenmc@createw.com
     * @return
     */
    @RequestMapping("/knowledgeList")
    public ModelAndView categoryList(){
    	List<TKnowledgeCategory> tKnowledgeCategories=tKnowledgeCategoryService.selectByExample(new TKnowledgeCategoryExample());
        return new ModelAndView(view+"/knowledgeList").addObject("tKnowledgeCategories", tKnowledgeCategories);
    }
    
    /**
     * 返回数据
     * @author 陈茂昌 2018年9月21日 下午4:11:38
     * @mail chenmc@createw.com
     * @param tKnowledgeCategory
     * @return
     */
    @RequestMapping("/listData")
    @ResponseBody
    public JSONObject listData(@ModelAttribute("tKnowledge") TKnowledge tKnowledge,@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
    	JSONObject jsonObject=new JSONObject();
    	TKnowledgeExample tKnowledgeExample=new TKnowledgeExample();
    	TKnowledgeExample.Criteria criteria=tKnowledgeExample.createCriteria();
    	if(StringUtils.isNotBlank(tKnowledge.getTitle())){
    		criteria.andTitleLike("%"+tKnowledge.getTitle()+"%");
    	}
    	if(StringUtils.isNotBlank(tKnowledge.getCategoryId())){
    		TKnowledgeCategoryExample categoryExample=new TKnowledgeCategoryExample();
    		TKnowledgeCategoryExample.Criteria categoryCriteria= categoryExample.createCriteria();
    		categoryCriteria.andPathLike("%"+tKnowledge.getCategoryId()+"%");
    		List<TKnowledgeCategory> tKnowledgeCategories=tKnowledgeCategoryService.selectByExample(categoryExample);
    		List<String> categoryIds=tKnowledgeCategories.stream().map(TKnowledgeCategory::getId).collect(Collectors.toList());
    		criteria.andCategoryIdIn(categoryIds);
    	}
    	if(tKnowledge.getCreateStart()!=null&&tKnowledge.getCreateEnd()!=null){
    		criteria.andCreateTimeBetween(tKnowledge.getCreateStart(), tKnowledge.getCreateEnd());
    	}
    	tKnowledgeExample.setOrderByClause("create_time desc");
    	criteria.andSysStatusEqualTo("1");
    	jsonObject.put("count", tKnowledgeService.countByExample(tKnowledgeExample));
    	tKnowledgeExample.setLimit("limit "+(page-1)*limit+","+limit);
    	List<TKnowledge> tKnowledges=tKnowledgeService.selectByExample(tKnowledgeExample);
    	jsonObject.put("data", tKnowledges);
    	jsonObject.put("code", 0);
    	return jsonObject;
    }
    
    /**
     * 新增数据
     * @author 陈茂昌 2018年9月21日 下午4:11:33
     * @mail chenmc@createw.com
     * @param tKnowledgeCategory
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(@ModelAttribute("tKnowledge") TKnowledge tKnowledge){
    	JSONObject rtnObj=new JSONObject();
    	if(StringUtils.isBlank(tKnowledge.getId())){
    		String uuid=UUID.randomUUID().toString().replace("-", "").toUpperCase();
        	tKnowledge.setId(uuid);
        	tKnowledgeService.insertSelective(tKnowledge);
    	}else{
    		tKnowledgeService.updateByPrimaryKeySelective(tKnowledge);
    	}
    	TKnowledgeCategory tKnowledgeCategory=tKnowledgeCategoryService.selectByPrimaryKey(tKnowledge.getCategoryId());
    	TKnowledgeExample example=new TKnowledgeExample();
    	example.createCriteria().andCategoryIdEqualTo(tKnowledge.getCategoryId()).andSysStatusEqualTo("1");
    	tKnowledgeCategory.setContentNum((int) tKnowledgeService.countByExample(example));
    	tKnowledgeCategoryService.updateByPrimaryKeySelective(tKnowledgeCategory);
    	rtnObj.put("success", true);
    	return rtnObj;
    }
    
    /**
     * 打开创建分类页面
     * @author 陈茂昌 2018年9月21日 下午4:11:28
     * @mail chenmc@createw.com
     * @param categoryId
     * @return
     */
	@RequestMapping("/knowledgeCreate")
	public ModelAndView knowledgeCreate(@RequestParam("id")String id) {
		TKnowledge tKnowledge=new TKnowledge();
		TKnowledgeCategory tKnowledgeCategory=new TKnowledgeCategory();
		ModelAndView modelAndView = new ModelAndView(view + "/knowledgeCreate");
		if(StringUtils.isNotBlank(id)){
			tKnowledge=tKnowledgeService.selectByPrimaryKey(id);
			modelAndView.addObject("tKnowledgeCategory", tKnowledgeCategoryService.selectByPrimaryKey(tKnowledge.getCategoryId()));
		}else{
			modelAndView.addObject("tKnowledgeCategory",tKnowledgeCategory);
		}
		modelAndView.addObject("tKnowledge", tKnowledge);
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
		TKnowledge tKnowledge=tKnowledgeService.selectByPrimaryKey(id);
		tKnowledge.setSysStatus("0");
		tKnowledgeService.updateByPrimaryKeySelective(tKnowledge);
		TKnowledgeCategory tKnowledgeCategory=tKnowledgeCategoryService.selectByPrimaryKey(tKnowledge.getCategoryId());
    	TKnowledgeExample example=new TKnowledgeExample();
    	example.createCriteria().andCategoryIdEqualTo(tKnowledge.getCategoryId()).andSysStatusEqualTo("1");
    	tKnowledgeCategory.setContentNum((int) tKnowledgeService.countByExample(example));
    	tKnowledgeCategoryService.updateByPrimaryKeySelective(tKnowledgeCategory);
		
		return rtnObj;
	}
	
    /**
     * 打开创建分类页面
     * @author 陈茂昌 2018年9月21日 下午4:11:28
     * @mail chenmc@createw.com
     * @param categoryId
     * @return
     */
	@RequestMapping("/knowledgeGet")
	public ModelAndView knowledgeGet(@RequestParam("id")String id) {
		TKnowledge tKnowledge=tKnowledgeService.selectByPrimaryKey(id);
		ModelAndView modelAndView = new ModelAndView(view + "/knowledgeGet");
		modelAndView.addObject("tKnowledgeCategory", tKnowledgeCategoryService.selectByPrimaryKey(tKnowledge.getCategoryId()));
		modelAndView.addObject("tKnowledge", tKnowledge);
		return modelAndView;
	}
    
}
