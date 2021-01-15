/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.service;

import com.gandalf.framework.ibatis.PaginationQueryList;
import com.gandalf.lottery.dao.entity.OpPermission;
import com.gandalf.lottery.dao.entity.OpPermissionExample;

/**
 * 权限
 * 
 * @author zhuxiaobing 2014-8-25 下午04:59:47
 */
public interface OpPermissionService {

    public PaginationQueryList<OpPermission> selectByPagination(OpPermissionExample example);

    public OpPermission selectByPrimaryKey(long permissionId);

    public int updateByPrimaryKey(OpPermission permission);

    public void insert(OpPermission permission);
}
