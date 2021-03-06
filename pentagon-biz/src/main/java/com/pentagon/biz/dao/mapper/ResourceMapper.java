package com.pentagon.biz.dao.mapper;

import java.util.List;

import com.gandalf.framework.mybatis.BaseMapper;
import com.pentagon.biz.dao.model.Resource;
import com.pentagon.biz.dao.model.ResourceExample;

public interface ResourceMapper extends BaseMapper<Resource, ResourceExample> {
    
	List<Resource> selectByUser(Long userId);
	
}