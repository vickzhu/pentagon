/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.service;

import java.util.List;

import com.gandalf.lottery.dao.entity.OpPermissionGroup;
import com.gandalf.lottery.dao.entity.OpPermissionGroupExample;

/**
 * 权限组
 * 
 * @author zhuxiaobing 2014-8-25 下午05:29:19
 */
public interface OpPermissionGroupService {

    public List<OpPermissionGroup> selectByExample(OpPermissionGroupExample example);

    public void add(OpPermissionGroup persmissionGroup);

    public int updateByPrimaryKey(OpPermissionGroup persmissionGroup);

    public int deleteByPrimaryKey(long permissionGroupId);
}
