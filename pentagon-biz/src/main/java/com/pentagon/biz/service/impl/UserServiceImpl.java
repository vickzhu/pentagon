package com.pentagon.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.gandalf.framework.mybatis.BaseMapper;
import com.gandalf.framework.mybatis.BaseServiceImpl;
import com.pentagon.biz.dao.mapper.UserMapper;
import com.pentagon.biz.dao.model.User;
import com.pentagon.biz.dao.model.UserExample;
import com.pentagon.biz.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserExample> implements UserService {

	@Resource
	private UserMapper mapper;
	
	@Override
	protected BaseMapper<User, UserExample> getMapper() {
		return mapper;
	}

	@Override
	public User selectByUsername(String username) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> userList = mapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(userList)) {
			return userList.get(0);
		}
		return null;
	}

}
