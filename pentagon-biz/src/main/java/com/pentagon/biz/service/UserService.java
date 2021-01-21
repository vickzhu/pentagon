package com.pentagon.biz.service;

import com.gandalf.framework.mybatis.BaseService;
import com.pentagon.biz.dao.model.User;
import com.pentagon.biz.dao.model.UserExample;

public interface UserService extends BaseService<User, UserExample> {

	public User selectByUsername(String username);
	
}
