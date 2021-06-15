/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.web.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gandalf.framework.constant.SymbolConstant;

/**
 * 类PermissionInterceptor.java的实现描述：权限拦截器
 * 
 * @author zhuxiaobing 2014-8-18 下午06:27:40
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    private String[]    anonymousUri;
    private PathMatcher matcher = new AntPathMatcher();

    /**
     * @param anonymousUri the anonymousUri to set
     */
    public void setAnonymousUri(String[] anonymousUri) {
        this.anonymousUri = anonymousUri;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        for (String exculdeURI : anonymousUri) {
            exculdeURI = contextPath + exculdeURI;
            if (matcher.match(exculdeURI, requestURI)) {
                return Boolean.TRUE;
            }
        }
        Object user = request.getSession().getAttribute("user");
        if(user != null) {
        	return Boolean.TRUE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(request.getContextPath());
        sb.append("/login?redirect=");
        StringBuilder redirectUrl = new StringBuilder();
        redirectUrl.append(request.getRequestURL());
        if(StringUtils.isNotBlank(request.getQueryString())) {
        	redirectUrl.append(SymbolConstant.QUESTION);
        	redirectUrl.append(request.getQueryString());
        }
        sb.append(URLEncoder.encode(redirectUrl.toString(), "UTF-8"));
        response.sendRedirect(sb.toString());
        return Boolean.FALSE;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

}
