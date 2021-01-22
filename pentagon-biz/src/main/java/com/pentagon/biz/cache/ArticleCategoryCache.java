package com.pentagon.biz.cache;

import java.util.List;

import com.pentagon.biz.dao.model.ArticleCategory;

public class ArticleCategoryCache {
	
	private static List<ArticleCategory> acList;
	private static long expireTime;

	private ArticleCategoryCache() {}
	
	/**
	 * 刷新缓存，默认五分钟的缓存
	 * @param acList
	 */
	public static void refreshCache(List<ArticleCategory> acList) {
		long expireTime = System.currentTimeMillis() + 300000;
		refreshCache(expireTime, acList);
	}
	
	/**
	 * 刷新缓存
	 * @param expireTime
	 * @param acList
	 */
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
