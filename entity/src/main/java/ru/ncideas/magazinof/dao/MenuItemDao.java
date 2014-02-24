package ru.ncideas.magazinof.dao;

import ru.ncideas.magazinof.entity.MenuItem;

import java.util.List;

public interface MenuItemDao {

    public List<MenuItem> getTopLevelMenu();

    public List<MenuItem> getSecondLevelMenu(MenuItem mi);
}
