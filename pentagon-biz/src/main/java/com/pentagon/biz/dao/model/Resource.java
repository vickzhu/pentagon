package com.pentagon.biz.dao.model;

public class Resource {
    private Long id;

    private Long baseMenuId;

    private String name;

    private Integer isMenu;

    private Integer menuOrder;

    private String uri;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }
}