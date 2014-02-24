package ru.ncideas.magazinof.entity;

import java.util.List;

public class MenuItem {

    Long id;

    String name;

    Long parentId;

    Boolean visible;

    //non db fields
    List<MenuItem> childList;

    public MenuItem() {
    }

    public MenuItem(String name, Long parentId, Boolean visible) {
        this.name = name;
        this.parentId = parentId;
        this.visible = visible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<MenuItem> getChildList() {
        return childList;
    }

    public void setChildList(List<MenuItem> childList) {
        this.childList = childList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItem menuItem = (MenuItem) o;

        if (!id.equals(menuItem.id)) return false;
        if (name != null ? !name.equals(menuItem.name) : menuItem.name != null) return false;
        if (parentId != null ? !parentId.equals(menuItem.parentId) : menuItem.parentId != null) return false;
        if (visible != null ? !visible.equals(menuItem.visible) : menuItem.visible != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (visible != null ? visible.hashCode() : 0);
        return result;
    }
}

