package com.pentagon.biz.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.gandalf.framework.mybatis.BaseMapper;
import com.pentagon.biz.dao.model.RoleResource;
import com.pentagon.biz.dao.model.RoleResourceExample;

public interface RoleResourceMapper extends BaseMapper<RoleResource, RoleResourceExample> {
 
	void batchInsert(@Param("roleId")Long roleId, @Param("resourceIds")Long[] resourceId);
	
}