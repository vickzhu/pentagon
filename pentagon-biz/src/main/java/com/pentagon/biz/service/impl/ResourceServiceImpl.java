package com.pentagon.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gandalf.framework.mybatis.BaseMapper;
import com.gandalf.framework.mybatis.BaseServiceImpl;
import com.pentagon.biz.dao.mapper.ResourceMapper;
import com.pentagon.biz.dao.model.Resource;
import com.pentagon.biz.dao.model.ResourceExample;

@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource, ResourceExample> implements ResourceService {

	@Autowired
	private ResourceMapper mapper;
	
	@Override
	protected BaseMapper<Resource, ResourceExample> getMapper() {
		return mapper;
	}
	
}
