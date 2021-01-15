/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.gandalf.framework.ibatis.PaginationQueryList;
import com.gandalf.lottery.dao.OpUserDAO;
import com.gandalf.lottery.dao.entity.OpUser;
import com.gandalf.lottery.dao.entity.OpUserExample;
import com.pentagon.service.OpUserService;

/**
 * 类OpUserServiceImpl.java的实现描述：用户
 * 
 * @author zhuxiaobing 2014-8-19 下午06:15:35
 */
@Service
public class OpUserServiceImpl implements OpUserService {

    @Resource
    private OpUserDAO userDAO;

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpUserService#selectByPagination(com.gandalf.framework.ibatis.BaseQuery,
     * com.gandalf.lottery.dao.entity.OpUserExample)
     */
    @Override
    public PaginationQueryList<OpUser> selectByPagination(OpUserExample example) {
        return userDAO.selectByPagination(example);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpUserService#selectByPrimaryKey(long)
     */
    @Override
    public OpUser selectByPrimaryKey(long userId) {
        return userDAO.selectByPrimaryKey(userId);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpUserService#updateByPrimaryKey(com.gandalf.lottery.dao.entity.OpUser)
     */
    @Override
    public int updateByPrimaryKey(OpUser user) {
        return userDAO.updateByPrimaryKey(user);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpUserService#insert(com.gandalf.lottery.dao.entity.OpUser)
     */
    @Override
    public void insert(OpUser user) {
        userDAO.insert(user);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpUserService#selectByUsername(java.lang.String)
     */
    @Override
    public OpUser selectByUsername(String username) {
        OpUserExample example = new OpUserExample();
        OpUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<OpUser> userList = userDAO.selectByExample(example);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
    }

}
