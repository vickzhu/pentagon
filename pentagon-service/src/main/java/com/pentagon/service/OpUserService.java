/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.service;

import com.gandalf.framework.ibatis.PaginationQueryList;
import com.gandalf.lottery.dao.entity.OpUser;
import com.gandalf.lottery.dao.entity.OpUserExample;

/**
 * 用户
 * 
 * @author zhuxiaobing 2014-8-19 下午06:15:02
 */
public interface OpUserService {

    public PaginationQueryList<OpUser> selectByPagination(OpUserExample example);

    public OpUser selectByPrimaryKey(long userId);

    public int updateByPrimaryKey(OpUser user);

    public void insert(OpUser user);

    /**
     * 用户名有唯一索引，这里如果找到的话必定只有一条记录
     * 
     * @param username
     * @return
     */
    public OpUser selectByUsername(String username);

}
