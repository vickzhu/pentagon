package com.pentagon.biz.cache;

import java.util.List;

import com.pentagon.biz.dao.model.ArticleCategory;

public class ArticleCategoryCache {
	
	private static List<ArticleCategory> acList;
	private static long expireTime;

	private ArticleCategoryCache() {}
	
	public static void refreshCache(long expireTime, List<ArticleCategory> acList) {
		ArticleCategoryCache.acList = acList;
		ArticleCategoryCache.expireTime = expireTime;
	}

	public static List<ArticleCategory> getAcList() {
		return acList;
	}

	public static long getExpireTime() {
		return expireTime;
	}

}
