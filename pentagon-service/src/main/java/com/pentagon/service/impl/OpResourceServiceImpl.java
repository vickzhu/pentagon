/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gandalf.framework.ibatis.PaginationQueryList;
import com.gandalf.lottery.dao.OpResourceDAO;
import com.gandalf.lottery.dao.entity.OpResource;
import com.gandalf.lottery.dao.entity.OpResourceExample;
import com.pentagon.service.OpResourceService;

/**
 * 资源
 * 
 * @author zhuxiaobing 2014-8-25 下午01:55:03
 */
@Service
public class OpResourceServiceImpl implements OpResourceService {

    @Resource
    private OpResourceDAO resourceDAO;

    /*
     * (non-Javadoc)
     * @see
     * com.gandalf.lottery.service.OpResourceService#selectByPagination(com.gandalf.lottery.dao.entity.OpResourceExample
     * )
     */
    @Override
    public PaginationQueryList<OpResource> selectByPagination(OpResourceExample example) {
        return resourceDAO.selectByPagination(example);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpResourceService#selectByPrimaryKey(long)
     */
    @Override
    public OpResource selectByPrimaryKey(long resourceId) {
        return resourceDAO.selectByPrimaryKey(resourceId);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpResourceService#updateByPrimaryKey(com.gandalf.lottery.dao.entity.OpResource)
     */
    @Override
    public int updateByPrimaryKey(OpResource resource) {
        return resourceDAO.updateByPrimaryKey(resource);
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.service.OpResourceService#insert(com.gandalf.lottery.dao.entity.OpResource)
     */
    @Override
    public void insert(OpResource resource) {
        resourceDAO.insert(resource);
    }

}
