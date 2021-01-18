package com.pentagon.biz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gandalf.framework.mybatis.BaseMapper;
import com.gandalf.framework.mybatis.BaseServiceImpl;
import com.pentagon.biz.dao.mapper.ArticleCategoryMapper;
import com.pentagon.biz.dao.model.ArticleCategory;
import com.pentagon.biz.dao.model.ArticleCategoryExample;
import com.pentagon.biz.service.ArticleCategoryService;

@Service
public class ArticleCategoryServiceImpl extends BaseServiceImpl<ArticleCategory, ArticleCategoryExample>
		implements ArticleCategoryService {

	@Resource
	private ArticleCategoryMapper mapper;
	
	@Override
	protected BaseMapper<ArticleCategory, ArticleCategoryExample> getMapper() {
		return mapper;
	}

}
