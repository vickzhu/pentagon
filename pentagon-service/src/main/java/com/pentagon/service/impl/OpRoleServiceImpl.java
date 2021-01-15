/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gandalf.framework.ibatis.PaginationQueryList;
import com.gandalf.lottery.dao.OpRoleDAO;
import com.gandalf.lottery.dao.entity.OpRole;
import com.gandalf.lottery.dao.entity.OpRoleExample;
import com.pentagon.service.OpRoleService;

/**
 * 角色
 * 
 * @author zhuxiaobing 2014-8-25 下午04:58:12
 */
@Service
public class OpRoleServiceImpl implements OpRoleService {

    @Resource
    private OpRoleDAO roleDAO;

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.RoleService#selectByPagination(com.gandalf.lottery.dao.entity.OpRoleExample)
     */
    @Override
    public PaginationQueryList<OpRole> selectByPagination(OpRoleExample example) {
        return roleDAO.selectByPagination(example);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.RoleService#selectByPrimaryKey(long)
     */
    @Override
    public OpRole selectByPrimaryKey(long roleId) {
        return roleDAO.selectByPrimaryKey(roleId);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.RoleService#updateByPrimaryKey(com.gandalf.lottery.dao.entity.OpRole)
     */
    @Override
    public int updateByPrimaryKey(OpRole role) {
        return roleDAO.updateByPrimaryKey(role);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpRoleService#insert(com.gandalf.lottery.dao.entity.OpRole)
     */
    @Override
    public void insert(OpRole role) {
        roleDAO.insert(role);
    }

}
