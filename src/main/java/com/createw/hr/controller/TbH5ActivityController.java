package com.createw.hr.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.createw.hr.bean.TbH5Activity;
import com.createw.hr.bean.TbH5ActivityExample;
import com.createw.hr.bean.TbH5ActivityExample.Criteria;
import com.createw.hr.service.TbH5ActivityService;

/**
 * 百科分类controller
 * @author 陈茂昌 2018年9月21日 下午4:11:40
 * @mail chenmc@createw.com
 */
@RestController
@RequestMapping("/tbH5Activity")
public class TbH5ActivityController {
    static final Logger LOGGER = LoggerFactory.getLogger(TbH5ActivityController.class);
    static final String view="tbH5Activity";
    @Resource
    TbH5ActivityService tbH5ActivityService;
    
    /**
     * 打开分类数据列表页面
     * @author 陈茂昌 2018年10月23日 下午4:11:31
     * @mail chenmc@createw.com
     * @return
     */
    @RequestMapping("/tbH5ActivityList")
    public ModelAndView tbH5ActivityList(){
        return new ModelAndView(view+"/tbH5ActivityList");
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
    public JSONObject listData(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,HttpServletRequest request){
    	JSONObject jsonObject=new JSONObject();
    	TbH5ActivityExample tbH5ActivityExample=new TbH5ActivityExample();
    	Criteria criteria=tbH5ActivityExample.createCriteria();
    	
    	String canalCode=request.getParameter("canalCode");
    	String canalName=request.getParameter("canalName");
    	String activityName=request.getParameter("activityName");
    	String telephone=request.getParameter("telephone");
    	String dataStatus=request.getParameter("dataStatus");
    	String createTime=request.getParameter("createTime");
    	
    	if(StringUtils.isNotBlank(canalCode)) {
    		criteria.andCanalCodeEqualTo(canalCode);
    	}
    	if(StringUtils.isNotBlank(canalName)) {
    		criteria.andCanalNameLike("%"+canalName+"%");
    	}
    	if(StringUtils.isNotBlank(activityName)) {
    		criteria.andActivityNameLike("%"+activityName+"%");
    	}
    	if(StringUtils.isNotBlank(telephone)) {
    		criteria.andTelephoneEqualTo(telephone);
    	}
    	if(StringUtils.isNotBlank(dataStatus)) {
    		criteria.andDataStatusEqualTo(dataStatus);
    	}
    	if(StringUtils.isNotBlank(createTime)) {
    		String[] time=createTime.split(" - ");
    		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    		try {
				criteria.andCreateTimeBetween(simpleDateFormat.parse(time[0]), simpleDateFormat.parse(time[1]));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
    	jsonObject.put("count", tbH5ActivityService.countByExample(tbH5ActivityExample));//先计数,后分页
    	tbH5ActivityExample.setOrderByClause("create_time desc");
    	tbH5ActivityExample.setLimit("limit "+(page-1)*limit+","+limit);
    	List<TbH5Activity> tbH5Activitys=tbH5ActivityService.selectByExample(tbH5ActivityExample);
    	jsonObject.put("data", tbH5Activitys);
    	jsonObject.put("code", 0);
    	return jsonObject;
    }



	
    /**
     * 打开创建分类页面
     * @author 陈茂昌 2018年10月23日 下午4:11:28
     * @mail chenmc@createw.com
     * @param id edit
     * @return
     */
	@RequestMapping("/tbH5ActivityGet")
	public ModelAndView tbH5ActivityGet(@RequestParam("id")String id,@RequestParam("edit")String edit) {
		ModelAndView modelAndView = new ModelAndView(view + "/tbH5ActivityGet");
		TbH5Activity tbH5Activity=new TbH5Activity();
		if(StringUtils.isNotBlank(id)) {
			tbH5Activity=tbH5ActivityService.selectByPrimaryKey(id);
		}
		if(StringUtils.isNotBlank(tbH5Activity.getContent())) {
			tbH5Activity.setContent(tbH5Activity.getContent().replace("][", "]<br/>[").replace("]", "").replace("[", "").replace("?", "? - "));;
		}
		modelAndView.addObject("tbH5Activity", tbH5Activity);
		modelAndView.addObject("edit", edit);
		return modelAndView;
	}
	
    /**
     * 打开创建分类页面
     * @author 陈茂昌 2018年10月23日 下午4:11:28
     * @mail chenmc@createw.com
     * @param id edit
     * @return
     */
	@RequestMapping("/tbH5ActivityCreate")
	public ModelAndView tbH5ActivityCreate() {
		ModelAndView modelAndView = new ModelAndView(view + "/tbH5ActivityCreate");
		return modelAndView;
	}
	
	@RequestMapping("/update")
	public JSONObject update(@ModelAttribute("tbH5Activity") TbH5Activity tbH5Activity) {
		JSONObject rtnObj=new JSONObject();
		try {
			tbH5ActivityService.updateByPrimaryKeySelective(tbH5Activity);
			rtnObj.put("success", true);
		} catch (Exception e) {
			rtnObj.put("success", false);
		}
		return rtnObj;
	}
	
	@RequestMapping("/save")
	public JSONObject save(@ModelAttribute("tbH5Activity") TbH5Activity tbH5Activity) {
		JSONObject rtnObj=new JSONObject();
		try {
			tbH5Activity.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
			tbH5ActivityService.insertSelective(tbH5Activity);
			rtnObj.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			rtnObj.put("success", false);
		}
		return rtnObj;
	}
    
}
