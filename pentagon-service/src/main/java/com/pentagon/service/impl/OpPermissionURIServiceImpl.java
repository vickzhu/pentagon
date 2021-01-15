/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gandalf.lottery.dao.OpPermissionURIDAO;
import com.pentagon.service.OpPermissionURIService;

/**
 * 权限URI关系
 * 
 * @author zhuxiaobing 2014-9-2 下午06:16:53
 */
@Service
public class OpPermissionURIServiceImpl implements OpPermissionURIService {

    @Resource
    private OpPermissionURIDAO permissionURIDAO;

}
