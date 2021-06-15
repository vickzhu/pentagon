package com.pentagon.biz.cache;

import java.util.List;

import com.pentagon.biz.dto.ResourceTree;

public class ResourceCache {
	
	private static List<ResourceTree> entityList;
	private static long expireTime;

	private ResourceCache() {}
	
	/**
	 * 刷新缓存，默认五分钟的缓存
	 * @param acList
	 */
	public static void refreshCache(List<ResourceTree> entityList) {
		long expireTime = System.currentTimeMillis() + 300000;
		refreshCache(expireTime, entityList);
	}
	
	/**
	 * 刷新缓存
	 * @param expireTime
	 * @param acList
	 */
	public static void refreshCache(long expireTime, List<ResourceTree> entityList) {
		ResourceCache.entityList = entityList;
		ResourceCache.expireTime = expireTime;
	}

	public static List<ResourceTree> getEntityList() {
		return entityList;
	}

	public static long getExpireTime() {
		return expireTime;
	}

}
