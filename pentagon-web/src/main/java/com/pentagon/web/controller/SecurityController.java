/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.web.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gandalf.framework.encrypt.PHPass;
import com.gandalf.framework.util.StringUtil;
import com.gandalf.framework.web.tool.RequestUtil;
import com.pentagon.biz.dao.model.User;
import com.pentagon.biz.service.UserService;

/**
 * 类SecurityController.java的实现描述：安全类
 * 
 * @author zhuxiaobing 2014-8-19 下午02:13:22
 */
@Controller
public class SecurityController {
	
	@Resource
	private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String captcha = request.getParameter("captcha");
        if (StringUtil.isBlank(username) || StringUtil.isBlank(password) || StringUtil.isBlank(captcha)) {
            return null;
        }
        Object captchaObj = request.getSession(false).getAttribute("captcha");
        if (captchaObj == null || !captcha.equalsIgnoreCase(String.valueOf(captchaObj))) {// 验证码不存在或已过期
        	return null;
        }
        User user = userService.selectByUsername(username);
        if(user.getEnable() == 0) {
        	return null;
        }
        request.getSession().setAttribute("user", user);
        return "redirect:dashboard";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("register");
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doSignUp(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rePwd = request.getParameter("rePassword");
        String captcha = request.getParameter("captcha");
        if (StringUtil.isBlank(username) || StringUtil.isBlank(password) || StringUtil.isBlank(captcha)) {
            return null;
        }
        if(!password.equals(rePwd)) {
        	return null;
        }
        Object captchaObj = request.getSession().getAttribute("captcha");
        if(captchaObj == null || !captcha.equalsIgnoreCase(String.valueOf(captchaObj))) {
        	return null;
        }
        String secPwd = PHPass.createHash(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(secPwd);
        user.setEnable(1);
        user.setLastLoginIp(RequestUtil.getIp(request));
        user.setLastLoginTime(new Date());
        userService.insert(user);
        return "redirect:login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
    	request.getSession(false).invalidate();
    	return "redirect:login";
    }
}
