package com.createw.hr.controller;

import java.util.List;
import java.util.UUID;

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
import com.createw.hr.bean.TKnowledgeCategory;
import com.createw.hr.bean.TKnowledgeCategoryExample;
import com.createw.hr.bean.TKnowledgeCategoryExample.Criteria;
import com.createw.hr.service.TKnowledgeCategoryService;
import com.createw.hr.utils.TreeUtils;

/**
 * 百科分类controller
 * @author 陈茂昌 2018年9月21日 下午4:11:40
 * @mail chenmc@createw.com
 */
@RestController
@RequestMapping("/tKnowledgeCategory")
public class TKnowledgeCategoryController {
    static final Logger LOGGER = LoggerFactory.getLogger(TKnowledgeCategoryController.class);
    static final String view="tKnowledgeCategory";
    @Resource
    TKnowledgeCategoryService tKnowledgeCategoryService;
    
    /**
     * 返回数据
     * @author 陈茂昌 2018年9月21日 下午4:11:38
     * @mail chenmc@createw.com
     * @param tKnowledgeCategory
     * @return
     */
    @RequestMapping("/listData")
    @ResponseBody
    public JSONObject listData(@ModelAttribute("tKnowledgeCategory") TKnowledgeCategory tKnowledgeCategory){
    	JSONObject jsonObject=new JSONObject();
    	TKnowledgeCategoryExample tKnowledgeCategoryExample=new TKnowledgeCategoryExample();
    	Criteria criteria=tKnowledgeCategoryExample.createCriteria();
    	
    	if(StringUtils.isNotBlank(tKnowledgeCategory.getCategoryName())){//只需要判断categoryName是否为空即可,因为时间在前端默认会传来
    		criteria.andCategoryNameEqualTo(tKnowledgeCategory.getCategoryName()).andCreateTimeBetween(tKnowledgeCategory.getCreateStart(), tKnowledgeCategory.getCreateEnd());
    	}
    	criteria.andSysStatusEqualTo("1");
    	tKnowledgeCategoryExample.setOrderByClause(" pid asc");
    	List<TKnowledgeCategory> tKnowledgeCategories=tKnowledgeCategoryService.selectByExample(tKnowledgeCategoryExample);
    	jsonObject.put("data", tKnowledgeCategories);
    	jsonObject.put("count", tKnowledgeCategories.size());
    	jsonObject.put("is", true);
    	jsonObject.put("code", 0);
    	return jsonObject;
    }
    
    /**
     * 更新操作
     * @author 陈茂昌 2018年9月21日 下午4:11:35
     * @mail chenmc@createw.com
     * @param tKnowledgeCategory
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public JSONObject update(@ModelAttribute("tKnowledgeCategory") TKnowledgeCategory tKnowledgeCategory){
    	JSONObject rtnObj=new JSONObject();
    	tKnowledgeCategoryService.updateByPrimaryKeySelective(tKnowledgeCategory);
    	rtnObj.put("success", true);
    	return rtnObj;
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
    public JSONObject save(@ModelAttribute("tKnowledgeCategory") TKnowledgeCategory tKnowledgeCategory){
    	JSONObject rtnObj=new JSONObject();
    	String uuid=UUID.randomUUID().toString().replace("-", "").toUpperCase();
    	tKnowledgeCategory.setId(uuid);
    	tKnowledgeCategory.setPath(tKnowledgeCategory.getPath()+uuid+"/");
    	tKnowledgeCategoryService.insertSelective(tKnowledgeCategory);
    	rtnObj.put("success", true);
    	return rtnObj;
    }
    
    /**
     * 打开分类数据列表页面
     * @author 陈茂昌 2018年9月21日 下午4:11:31
     * @mail chenmc@createw.com
     * @return
     */
    @RequestMapping("/categoryList")
    public ModelAndView categoryList(){
        return new ModelAndView(view+"/categoryList");
    }
    
    /**
     * 打开创建分类页面
     * @author 陈茂昌 2018年9月21日 下午4:11:28
     * @mail chenmc@createw.com
     * @param categoryId
     * @return
     */
    @RequestMapping("/categoryCreate")
    public ModelAndView categoryCreate(@RequestParam("categoryId")String categoryId){
    	TKnowledgeCategory tKnowledgeCategory;
    	if(StringUtils.isNotBlank(categoryId)){
    		tKnowledgeCategory=tKnowledgeCategoryService.selectByPrimaryKey(categoryId);
    	}else{
    		tKnowledgeCategory=new TKnowledgeCategory();
    		tKnowledgeCategory.setId("0");
    		tKnowledgeCategory.setCategoryLevel(0);
    		tKnowledgeCategory.setPath("0/");
    	}
    	ModelAndView modelAndView=new ModelAndView(view+"/categoryCreate").addObject("tKnowledgeCategory", tKnowledgeCategory);
        return modelAndView;
    }
    
    /**
     * 打开编辑分类页面
     * @author 陈茂昌 2018年9月21日 下午4:11:26
     * @mail chenmc@createw.com
     * @param categoryId
     * @return
     */
    @RequestMapping("/categoryEdit")
    public ModelAndView categoryEdit(@RequestParam("categoryId")String categoryId){
    	TKnowledgeCategory tKnowledgeCategory=tKnowledgeCategoryService.selectByPrimaryKey(categoryId);
        return new ModelAndView(view+"/categoryEdit").addObject("tKnowledgeCategory", tKnowledgeCategory);
    }
    
    /**
     * 删除分类操作
	*@authod 陈茂昌 2018年9月21日 下午4:11:22
	*@mail chenmaochang@createw.com
	*@param request
	*@param response
	*@retuen rtnObj
	*/
	@RequestMapping("delete")
	@ResponseBody
	public JSONObject delete(@RequestParam("categoryId")String categoryId) {
		JSONObject rtnObj = new JSONObject();//use to return
		TKnowledgeCategory tKnowledgeCategory=tKnowledgeCategoryService.selectByPrimaryKey(categoryId);
		tKnowledgeCategory.setSysStatus("0");
		tKnowledgeCategoryService.updateByPrimaryKeySelective(tKnowledgeCategory);
		return rtnObj;
	}
    
	/**
	*@authod 陈茂昌 2018年9月25日 下午4:19:20
	*@mail chenmaochang@createw.com
	*@param request
	*@param response
	*@retuen rtnObj
	*/
	@RequestMapping("getTreeCategory")
	@ResponseBody
	public List<TKnowledgeCategory> getTreeCategory() {
		TKnowledgeCategoryExample tKnowledgeCategoryExample=new TKnowledgeCategoryExample();
		List<TKnowledgeCategory> tKnowledgeCategories=tKnowledgeCategoryService.selectByExample(tKnowledgeCategoryExample);
		List<TKnowledgeCategory> treeKnolwdgeCategory=TreeUtils.getTree(tKnowledgeCategories);
		return treeKnolwdgeCategory;
	}
	
	
	@RequestMapping("categorySelect")
	public ModelAndView categorySelect(){
		return new ModelAndView(view+"/categorySelect");
	}
}
