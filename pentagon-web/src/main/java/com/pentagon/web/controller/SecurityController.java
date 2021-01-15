/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gandalf.framework.util.StringUtil;

/**
 * 类SecurityController.java的实现描述：安全类
 * 
 * @author zhuxiaobing 2014-8-19 下午02:13:22
 */
@Controller
public class SecurityController {

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
//        Object captchaObj = request.getSession(false).getAttribute("captchaCode");
//        if (captchaObj == null) {// 验证码不存在或已过期
//        	
//        }
//        ModelAndView mav = new ModelAndView("dashboard");
        return "redirect:dashboard";
    }
}
