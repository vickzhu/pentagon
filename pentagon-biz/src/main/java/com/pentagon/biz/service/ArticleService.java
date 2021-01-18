package com.pentagon.biz.service;

import com.gandalf.framework.mybatis.BaseService;
import com.gandalf.framework.web.tool.Page;
import com.pentagon.biz.dao.model.Article;
import com.pentagon.biz.dao.model.ArticleExample;

public interface ArticleService extends BaseService<Article, ArticleExample> {
	
	public void selectByPagination(ArticleExample example, Page<Article> page);

}
