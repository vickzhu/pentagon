/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.service;

import com.gandalf.framework.ibatis.PaginationQueryList;
import com.gandalf.lottery.dao.entity.OpRole;
import com.gandalf.lottery.dao.entity.OpRoleExample;

/**
 * 角色
 * 
 * @author zhuxiaobing 2014-8-25 下午04:57:23
 */
public interface OpRoleService {

    public PaginationQueryList<OpRole> selectByPagination(OpRoleExample example);

    public OpRole selectByPrimaryKey(long roleId);

    public int updateByPrimaryKey(OpRole role);

    public void insert(OpRole role);
}
