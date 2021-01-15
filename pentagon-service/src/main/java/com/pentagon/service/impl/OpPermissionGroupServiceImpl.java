/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gandalf.lottery.dao.OpPermissionGroupDAO;
import com.gandalf.lottery.dao.entity.OpPermissionGroup;
import com.gandalf.lottery.dao.entity.OpPermissionGroupExample;
import com.pentagon.service.OpPermissionGroupService;

/**
 * 权限组
 * 
 * @author zhuxiaobing 2014-8-25 下午05:30:53
 */
@Service
public class OpPermissionGroupServiceImpl implements OpPermissionGroupService {

    @Resource
    private OpPermissionGroupDAO permissionGroupDAO;

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpPermissionGroupService#selectByExample(com.gandalf.lottery.dao.entity.
     * OpPermissionGroupExample)
     */
    @Override
    public List<OpPermissionGroup> selectByExample(OpPermissionGroupExample example) {
        return permissionGroupDAO.selectByExample(example);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpPermissionGroupService#add(com.gandalf.lottery.dao.entity.OpPermissionGroup)
     */
    @Override
    public void add(OpPermissionGroup persmissionGroup) {
        permissionGroupDAO.insert(persmissionGroup);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpPermissionGroupService#updateByPrimaryKey(com.gandalf.lottery.dao.entity.
     * OpPermissionGroup)
     */
    @Override
    public int updateByPrimaryKey(OpPermissionGroup persmissionGroup) {
        return permissionGroupDAO.updateByPrimaryKey(persmissionGroup);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpPermissionGroupService#deleteByPrimaryKey(long)
     */
    @Override
    public int deleteByPrimaryKey(long permissionGroupId) {
        return permissionGroupDAO.deleteByPrimaryKey(permissionGroupId);
    }

}
