package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.MenuItemDao;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.MenuItemRowMapper;
import ru.ncideas.magazinof.entity.MenuItem;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemDaoSpringJdbcImpl extends AbstractSpringJdbc implements MenuItemDao {

    private String tableName = "menu_items";

    public List<MenuItem> getTopLevelMenu() {
        //get all menus
        List<MenuItem> menuItems = getJdbcTemplate().query("SELECT * FROM " + tableName + " " +
                "WHERE visible = true",
                new MenuItemRowMapper());

        //prepare topLevel menus
        List<MenuItem> topLevelItems = new ArrayList<MenuItem>();
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getParentId() == 0) {
                topLevelItems.add(menuItem);
            }
        }

        //populate topLevel menus children
        for (MenuItem topLevelItem : topLevelItems) {
            List<MenuItem> childList = new ArrayList<MenuItem>();
            for (MenuItem menuItem : menuItems) {
                if (menuItem.getParentId().toString().equals(topLevelItem.getId().toString())) {
                    childList.add(menuItem);
                }
            }
            topLevelItem.setChildList(childList);
        }

        return topLevelItems;
    }

    public List<MenuItem> getSecondLevelMenu(MenuItem mi) {
        List<MenuItem> menuItems = getNamedJdbcTemplate().query("SELECT * FROM " + tableName + " " +
                "WHERE parent_id = :parent_id AND visible = true",
                new MapSqlParameterSource("parent_id", mi.getId()),
                new MenuItemRowMapper());

        return menuItems;
    }

}
