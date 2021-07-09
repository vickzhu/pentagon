/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gandalf.framework.encrypt.PHPass;
import com.gandalf.framework.util.StringUtil;
import com.gandalf.framework.web.tool.RequestUtil;
import com.gandalf.framework.web.tool.SessionHolder;
import com.pentagon.biz.dao.model.Resource;
import com.pentagon.biz.dao.model.User;
import com.pentagon.biz.service.ResourceService;
import com.pentagon.biz.service.UserService;

/**
 * 类SecurityController.java的实现描述：安全类
 * 
 * @author zhuxiaobing 2014-8-19 下午02:13:22
 */
@Controller
public class SecurityController {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private ResourceService resourceService;
	
	private static final String defaulRedirectURL = "dashboard";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
    	String redirectUrl = request.getParameter("redirect");
        ModelAndView mav = new ModelAndView("login");
        if(StringUtils.isNotBlank(redirectUrl)) {
        	mav.addObject("redirect", redirectUrl);
        }
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, HttpServletResponse response, final RedirectAttributes redirectAttributes) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String captcha = request.getParameter("captcha");
        if (StringUtil.isBlank(username) || StringUtil.isBlank(password) || StringUtil.isBlank(captcha)) {
            return null;
        }
        Object captchaObj = request.getSession(false).getAttribute("captcha");
        if (captchaObj == null || !captcha.equalsIgnoreCase(String.valueOf(captchaObj))) {// 验证码不存在或已过期
        	redirectAttributes.addFlashAttribute("errorMsg", "验证码错误");
            return "redirect:/login";
        }
        User user = userService.selectByUsername(username);
        if(user.getEnable() == 0) {
        	redirectAttributes.addFlashAttribute("errorMsg", "该用户已禁用");
            return "redirect:/login";
        }
        if(!PHPass.isMatch(password, user.getPassword())) {
        	redirectAttributes.addFlashAttribute("errorMsg", "账号密码错误");
        	return "redirect:/login";
        }
        SessionHolder.setAttribute("user", user);
        String redirectUrl = getRedirectUrl(request);
//        response.sendRedirect(redirectUrl);
        return "redirect:" + redirectUrl;
    }
    
    private void loadPermission(User user) {
    	List<Resource> resourceList = resourceService.selectByUser(user.getId());
    	for (Resource resource : resourceList) {
			
		}
    }
    
    private String getRedirectUrl(HttpServletRequest request) {
    	String redirectUrl = request.getParameter("redirect");
        if(StringUtils.isNotBlank(redirectUrl)) {
        	try {
				redirectUrl = URLDecoder.decode(redirectUrl, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				redirectUrl = defaulRedirectURL;
				logger.error("Can't decode url:" + redirectUrl, e);
			}
        } else {
        	redirectUrl = defaulRedirectURL;
        }
        return redirectUrl;
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
        userService.insertSelective(user);
        return "redirect:login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
    	request.getSession(false).invalidate();
    	return "redirect:login";
    }
}
