package com.pentagon.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gandalf.framework.mybatis.BaseMapper;
import com.gandalf.framework.mybatis.BaseServiceImpl;
import com.gandalf.framework.web.tool.Page;
import com.pentagon.biz.dao.mapper.ArticleMapper;
import com.pentagon.biz.dao.model.Article;
import com.pentagon.biz.dao.model.ArticleExample;
import com.pentagon.biz.service.ArticleService;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article, ArticleExample> implements ArticleService {
	
	@Resource
	private ArticleMapper mapper;

	@Override
	protected BaseMapper<Article, ArticleExample> getMapper() {
		return mapper;
	}
	
	@Override
	public void selectByPagination(ArticleExample example, Page<Article> page) {
		example.setOffset(page.getOffset());
        example.setRows(page.getPageSize());
        int totalCounts = mapper.countByExample(example);
        page.setTotalCounts(totalCounts);
        List<Article> aList = mapper.selectByExample(example);
        page.setRecords(aList);
	}

}
