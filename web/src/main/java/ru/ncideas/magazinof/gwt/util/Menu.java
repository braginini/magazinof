package ru.ncideas.magazinof.gwt.util;

import ru.ncideas.magazinof.gwt.client.dto.MenuItemDto;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private static List<MenuItemDto> menuItems;

    public Menu() {
        Menu.menuItems = new ArrayList<MenuItemDto>();
    }

    public Menu(List<MenuItemDto> menuItems) {
        setMenuItems(menuItems);
    }

    public static List<MenuItemDto> getTopLevelMenu() {
        return Menu.menuItems;
    }

    public static void setMenuItems(List<MenuItemDto> menuItems) {
        Menu.menuItems = menuItems;
        for (MenuItemDto mi : menuItems) {
            MenuEnum.getByMenuItem(mi);
            for (MenuItemDto child : mi.getChildList()) {
                MenuEnum.getByMenuItem(child);
            }
        }
    }

    public static List<MenuItemDto> getSecondLevelMenu(MenuItemDto dto) {
        return dto.getChildList();
    }

    public static boolean initialized() {
        return Menu.menuItems != null
                && Menu.menuItems.size() > 0;
    }
}
