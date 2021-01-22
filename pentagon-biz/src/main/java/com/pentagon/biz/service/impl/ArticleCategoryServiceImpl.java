package com.pentagon.biz.service.impl;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gandalf.framework.mybatis.BaseMapper;
import com.gandalf.framework.mybatis.BaseServiceImpl;
import com.pentagon.biz.cache.ArticleCategoryCache;
import com.pentagon.biz.dao.mapper.ArticleCategoryMapper;
import com.pentagon.biz.dao.model.ArticleCategory;
import com.pentagon.biz.dao.model.ArticleCategoryExample;
import com.pentagon.biz.service.ArticleCategoryService;

@Service
public class ArticleCategoryServiceImpl extends BaseServiceImpl<ArticleCategory, ArticleCategoryExample>
		implements ArticleCategoryService {
	
	private static Lock lock = new ReentrantLock();

	@Resource
	private ArticleCategoryMapper mapper;
	
	@Override
	protected BaseMapper<ArticleCategory, ArticleCategoryExample> getMapper() {
		return mapper;
	}

	@Override
	public List<ArticleCategory> selectAllFromCache() {
		long currentTime = System.currentTimeMillis();
		long expireTime = ArticleCategoryCache.getExpireTime();
		if(currentTime < expireTime) {
			return ArticleCategoryCache.getAcList();
		}
		if(lock.tryLock()) {
			try {
				List<ArticleCategory> result = mapper.selectByExample(null);
				ArticleCategoryCache.refreshCache(result);
			} finally {
				lock.unlock();
			}
		}
		return ArticleCategoryCache.getAcList();
	}

}
