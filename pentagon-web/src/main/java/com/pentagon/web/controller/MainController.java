/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类MainController.java的实现描述：首页
 * 
 * @author zhuxiaobing 2014-8-19 下午02:09:17
 */
@Controller
public class MainController {
	
    @RequestMapping(value = "/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping(value = "/dashboard")
    public ModelAndView demo(HttpServletRequest request, HttpServletResponse response) {
    	ModelAndView mav = new ModelAndView("home");
    	List<String> menuList = new ArrayList<String>();
		menuList.add("订单管理");
		menuList.add("商户管理");
		menuList.add("联盟管理");
		menuList.add("用户管理");
		mav.addObject("menuList", menuList);
        return mav;
    }
}
