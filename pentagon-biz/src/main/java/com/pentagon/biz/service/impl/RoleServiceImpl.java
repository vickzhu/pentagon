package com.pentagon.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gandalf.framework.mybatis.BaseMapper;
import com.gandalf.framework.mybatis.BaseServiceImpl;
import com.pentagon.biz.dao.mapper.RoleMapper;
import com.pentagon.biz.dao.mapper.RoleResourceMapper;
import com.pentagon.biz.dao.model.Role;
import com.pentagon.biz.dao.model.RoleExample;
import com.pentagon.biz.dao.model.RoleResourceExample;
import com.pentagon.biz.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleExample> implements RoleService {
	
	@Autowired
	private RoleMapper mapper;
	@Autowired
	private RoleResourceMapper rrMapper;

	@Override
	protected BaseMapper<Role, RoleExample> getMapper() {
		return mapper;
	}

	@Override
	public List<Role> getRolesByUser(Long userId) {
		List<Long> roleIds = mapper.selectByUserId(userId);
		return null;
	}

	@Override
	public void assignResource(Long roleId, Long[] resourceIds) {
		RoleResourceExample rrExample = new RoleResourceExample();
		RoleResourceExample.Criteria criteria = rrExample.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		rrMapper.deleteByExample(rrExample);
		rrMapper.batchInsert(roleId, resourceIds);
	}

}
