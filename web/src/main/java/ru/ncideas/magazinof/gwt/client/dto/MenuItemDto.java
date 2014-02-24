package ru.ncideas.magazinof.gwt.client.dto;

import java.io.Serializable;
import java.util.List;

public class MenuItemDto implements Serializable {

    Long id;
    String name;
    List<FunctionDto> functions;
    Long parentId;
    List<MenuItemDto> childList;

    public MenuItemDto() {
    }

    public MenuItemDto(String name, List<FunctionDto> functions, Long parentId, List<MenuItemDto> childList) {
        this.name = name;
        this.functions = functions;
        this.parentId= parentId;
        this.childList = childList;
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

    public List<FunctionDto> getFunctions() {
        return functions;
    }

    public void setFunctions(List<FunctionDto> functions) {
        this.functions = functions;
    }

    public Long getParent() {
        return parentId;
    }

    public void setParent(Long parentId) {
        this.parentId = parentId;
    }

    public List<MenuItemDto> getChildList() {
        return childList;
    }

    public void setChildList(List<MenuItemDto> childList) {
        this.childList = childList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItemDto menuItem = (MenuItemDto) o;

        if (!id.equals(menuItem.id)) return false;
        if (!name.equals(menuItem.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

