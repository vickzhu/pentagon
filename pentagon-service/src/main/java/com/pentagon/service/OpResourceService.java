/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.pentagon.service;

import com.gandalf.framework.ibatis.PaginationQueryList;
import com.gandalf.lottery.dao.entity.OpResource;
import com.gandalf.lottery.dao.entity.OpResourceExample;

/**
 * 资源
 * 
 * @author zhuxiaobing 2014-8-19 下午06:15:02
 */
public interface OpResourceService {

    public PaginationQueryList<OpResource> selectByPagination(OpResourceExample example);

    public OpResource selectByPrimaryKey(long resourceId);

    public int updateByPrimaryKey(OpResource resource);

    public void insert(OpResource resource);

}
