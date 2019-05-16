package com.createw.hr.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

@RestController
public class LoginController {

    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public ModelAndView notLogin() {
    	ModelAndView modelAndView=new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public String notRole() {
        return "您没有权限！";
    }

    /*@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public JSONObject logout() {
    	JSONObject rtnObj=new JSONObject();
        try {
        	Subject subject = SecurityUtils.getSubject();
            //注销
            subject.logout();
            rtnObj.put("success", true);
		} catch (Exception e) {
			rtnObj.put("success", false);
		}
        return rtnObj;
    }*/
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
    	ModelAndView modelAndView=new ModelAndView();
        try {
        	Subject subject = SecurityUtils.getSubject();
            //注销
            subject.logout();
            modelAndView.setViewName("index");
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("index");
		}
        return modelAndView;
    }

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(String username, String password) {
    	JSONObject rtnObj=new JSONObject();
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
        	subject.login(token);
        	rtnObj.put("success", true);
		} catch (Exception e) {
			rtnObj.put("success", false);
			rtnObj.put("msg", "登录失败");
		}
        return rtnObj;
    }
}

