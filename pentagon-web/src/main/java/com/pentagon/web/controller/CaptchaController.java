/*
 * Copyright 2010-2013 onsean.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.web.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gandalf.framework.util.CaptchaUtil;

/**
 * 类VerifyCodeController.java的实现描述：验证码通用
 * 
 * @author zhuxiaobing 2013-7-11 下午3:59:27
 */
@Controller
@RequestMapping("/captcha")
public class CaptchaController {

    @RequestMapping(value = "/captcha.jpg", method = RequestMethod.GET)
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        String captchaCode = CaptchaUtil.generateVerifyCode(4);
        CaptchaUtil.outputImage(100, 30, out, captchaCode);
        request.getSession().setAttribute("captcha", captchaCode);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

}
