package com.pentagon.biz.service;

import java.util.List;

import com.gandalf.framework.mybatis.BaseService;
import com.pentagon.biz.dao.model.Role;
import com.pentagon.biz.dao.model.RoleExample;

public interface RoleService extends BaseService<Role, RoleExample> {

	public List<Role> getRolesByUser(Long userId);
	
	public void assignResource(Long roleId, Long[] resourceIds);
	
}
