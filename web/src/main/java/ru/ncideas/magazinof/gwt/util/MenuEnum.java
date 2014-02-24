package ru.ncideas.magazinof.gwt.util;

import ru.ncideas.magazinof.gwt.client.dto.MenuItemDto;

public enum MenuEnum {
    HOME(1001), SALES(1002), SHIPPING(1003), ORGANIZATION(1004), WAREHOUSES(1005), CATALOG(1006), REPORTS(1007), ADMINISTRATION(10001),

    //HOME

    //SALES
    ORDERS(2201), INVOICES_TO_CUSTOMERS(2202), SALES_RETURNS(2203),

    //CATALOG
    GOODS(2601),

    // ADMINISTRATION
    USERS(10101),
    SETTINGS(10102);

    int id;
    static MenuItemDto menuItem;

    MenuEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public MenuItemDto getMenuItem() {
        return MenuEnum.menuItem;
    }

    public void setMenuItem(MenuItemDto menuItem) {
        if (MenuEnum.menuItem == null) {
            MenuEnum.menuItem = menuItem;
        }
    }

    public static MenuEnum getByMenuItem(MenuItemDto mi) {
        for (MenuEnum me : MenuEnum.values()) {
            if (me.getId() == mi.getId()) {
                me.setMenuItem(mi);
                return me;
            }
        }
        return null;
    }
}
