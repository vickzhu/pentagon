/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gandalf.framework.ibatis.PaginationQueryList;
import com.gandalf.lottery.dao.OpPermissionDAO;
import com.gandalf.lottery.dao.entity.OpPermission;
import com.gandalf.lottery.dao.entity.OpPermissionExample;
import com.pentagon.service.OpPermissionService;

/**
 * 权限
 * 
 * @author zhuxiaobing 2014-8-25 下午05:00:30
 */
@Service
public class OpPermissionServiceImpl implements OpPermissionService {

    @Resource
    private OpPermissionDAO permissionDAO;

    /*
     * (non-Javadoc)
     * @see
     * com.gandalf.lottery.service.PermissionService#selectByPagination(com.gandalf.lottery.dao.entity.OpPermissionExample
     * )
     */
    @Override
    public PaginationQueryList<OpPermission> selectByPagination(OpPermissionExample example) {
        return permissionDAO.selectByPagination(example);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.PermissionService#selectByPrimaryKey(long)
     */
    @Override
    public OpPermission selectByPrimaryKey(long permissionId) {
        return permissionDAO.selectByPrimaryKey(permissionId);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.gandalf.lottery.service.PermissionService#updateByPrimaryKey(com.gandalf.lottery.dao.entity.OpPermission)
     */
    @Override
    public int updateByPrimaryKey(OpPermission permission) {
        return permissionDAO.updateByPrimaryKey(permission);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpPermissionService#insert(com.gandalf.lottery.dao.entity.OpPermission)
     */
    @Override
    public void insert(OpPermission permission) {
        permissionDAO.insert(permission);
    }

}
