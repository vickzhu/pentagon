package com.pentagon.biz.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gandalf.framework.mybatis.BaseMapper;
import com.gandalf.framework.mybatis.BaseServiceImpl;
import com.pentagon.biz.cache.ResourceCache;
import com.pentagon.biz.dao.mapper.ResourceMapper;
import com.pentagon.biz.dao.mapper.RoleResourceMapper;
import com.pentagon.biz.dao.model.Resource;
import com.pentagon.biz.dao.model.ResourceExample;
import com.pentagon.biz.dao.model.RoleResource;
import com.pentagon.biz.dao.model.RoleResourceExample;
import com.pentagon.biz.dto.ResourceTree;
import com.pentagon.biz.service.ResourceService;

@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource, ResourceExample> implements ResourceService {

	@Autowired
	private ResourceMapper mapper;
	@Autowired
	private RoleResourceMapper rrMapper;
	
	private static Lock treeLock = new ReentrantLock();
	
	@Override
	protected BaseMapper<Resource, ResourceExample> getMapper() {
		return mapper;
	}

	/**
	 * 每一个resource都有一个base_menu_id，表示该resoruce属于哪个menu下
	 */
	@Override
	public List<ResourceTree> selectAllFromCache() {
		long currentTime = System.currentTimeMillis();
		long expireTime = ResourceCache.getExpireTime();
		if(currentTime < expireTime) {
			return ResourceCache.getEntityList();
		}
		if(treeLock.tryLock()) {
			try {
				ResourceExample example = new ResourceExample();
				ResourceExample.Criteria criteria = example.createCriteria();
				criteria.andBaseMenuIdGreaterThan(-1l);
				example.setOrderByClause("base_menu_id asc, menu_order asc");
				List<Resource> result = mapper.selectByExample(example); 
				Map<Long, List<ResourceTree>> subResourceMap = new HashMap<Long, List<ResourceTree>>();
				for (Resource resource : result) {//统计每个menu下的第一级resource
					Long baseMenuId = resource.getBaseMenuId();
					List<ResourceTree> treeList = subResourceMap.get(baseMenuId);
					if(treeList == null) {
						treeList = new ArrayList<ResourceTree>();
						subResourceMap.put(resource.getBaseMenuId(), treeList);
					}
					ResourceTree rt = new ResourceTree();
					rt.setId(resource.getId());
					rt.setBaseMenuId(resource.getBaseMenuId());
					rt.setIsMenu(resource.getIsMenu());
					rt.setName(resource.getName());
					treeList.add(rt);
				}
				ResourceTree resourceTree = new ResourceTree();
				List<ResourceTree> resourceList = subResourceMap.get(0l);//获根resource
				resourceTree.setTreeList(resourceList);
				buildSubTree(resourceTree, subResourceMap);
				ResourceCache.refreshCache(resourceList);
			} finally {
				treeLock.unlock();
			}
		}
		return ResourceCache.getEntityList();
	}
	
	/**
	 * 递归构建resource树形结构
	 * @param resourceTree	根resource
	 * @param subResourceMap	所有menu下的一级resource
	 */
	private void buildSubTree(ResourceTree resourceTree, Map<Long, List<ResourceTree>> subResourceMap) {
		List<ResourceTree> resourceList = resourceTree.getTreeList();
		if(CollectionUtils.isEmpty(resourceList)) {
			return;
		}
		for (ResourceTree rt : resourceList) {
			List<ResourceTree> rtList = subResourceMap.get(rt.getId());
			rt.setTreeList(rtList);
			if(rt.getIsMenu() == 1) {//菜单
				buildSubTree(rt, subResourceMap);
			}
		}
	}

	@Override
	public Set<Long> getResourcesForRole(Long roleId) {
		RoleResourceExample example = new RoleResourceExample();
		RoleResourceExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		List<RoleResource> rrList = rrMapper.selectByExample(example);
		Set<Long> resourceIdSet = new HashSet<Long>();
		for (RoleResource roleResource : rrList) {
			resourceIdSet.add(roleResource.getResourceId());
		}
		return resourceIdSet;
	}

	@Override
	public List<Resource> getResourcesForRoles(Long[] roleIds) {
		
		return null;
	}

	@Override
	public List<Resource> selectByUser(Long userId) {
		return mapper.selectByUser(userId);
	}
	
}
