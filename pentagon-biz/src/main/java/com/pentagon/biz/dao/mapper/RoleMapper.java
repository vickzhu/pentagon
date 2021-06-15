package com.pentagon.biz.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gandalf.framework.mybatis.BaseMapper;
import com.pentagon.biz.dao.model.Role;
import com.pentagon.biz.dao.model.RoleExample;

public interface RoleMapper extends BaseMapper<Role, RoleExample> {
	
	public List<Long> selectByUserId(@Param("userId") Long userId);
	
}