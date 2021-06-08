package com.pentagon.biz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gandalf.framework.mybatis.BaseMapper;
import com.gandalf.framework.mybatis.BaseServiceImpl;
import com.pentagon.biz.dao.mapper.RoleMapper;
import com.pentagon.biz.dao.model.Role;
import com.pentagon.biz.dao.model.RoleExample;
import com.pentagon.biz.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleExample> implements RoleService {
	
	@Resource
	private RoleMapper mapper;

	@Override
	protected BaseMapper<Role, RoleExample> getMapper() {
		return mapper;
	}	

}
