package com.pentagon.biz.service;

import java.util.List;

import com.gandalf.framework.mybatis.BaseService;
import com.pentagon.biz.dao.model.ArticleCategory;
import com.pentagon.biz.dao.model.ArticleCategoryExample;

public interface ArticleCategoryService extends BaseService<ArticleCategory, ArticleCategoryExample> {

	public List<ArticleCategory> selectAllFromCache();
	
}
