package com.pentagon.biz.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 资源树
 * 
 * @author vick.zhu
 *
 */
public class ResourceTree implements Serializable {

	private static final long serialVersionUID = -4846435992364353556L;

	private Long id;

	private Long baseMenuId;

	private String name;

	private Integer isMenu;

	private List<ResourceTree> treeList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBaseMenuId() {
		return baseMenuId;
	}

	public void setBaseMenuId(Long baseMenuId) {
		this.baseMenuId = baseMenuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}

	public List<ResourceTree> getTreeList() {
		return treeList;
	}

	public void setTreeList(List<ResourceTree> treeList) {
		this.treeList = treeList;
	}

}
