package com.pentagon.biz.service;

import java.util.List;
import java.util.Set;

import com.gandalf.framework.mybatis.BaseService;
import com.pentagon.biz.dao.model.Resource;
import com.pentagon.biz.dao.model.ResourceExample;
import com.pentagon.biz.dto.ResourceTree;

public interface ResourceService extends BaseService<Resource, ResourceExample> {

	public List<ResourceTree> selectAllFromCache();
	
	public Set<Long> getResourcesForRole(Long roleId);
	
	public List<Resource> getResourcesForRoles(Long[] roleIds);
	
	public List<Resource> selectByUser(Long userId);
	
}
