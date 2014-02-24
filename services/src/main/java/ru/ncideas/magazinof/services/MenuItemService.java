package ru.ncideas.magazinof.services;

import ru.ncideas.magazinof.entity.MenuItem;

import java.util.List;

public interface MenuItemService {

    public List<MenuItem> getTopLevelMenu();

    public List<MenuItem> getSecondLevelMenu(MenuItem mi);

}
