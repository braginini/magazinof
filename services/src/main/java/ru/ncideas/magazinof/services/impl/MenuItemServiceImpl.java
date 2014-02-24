package ru.ncideas.magazinof.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.MenuItemDao;
import ru.ncideas.magazinof.entity.MenuItem;
import ru.ncideas.magazinof.services.MenuItemService;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    MenuItemDao menuItemDao;

    public List<MenuItem> getTopLevelMenu() {
        return menuItemDao.getTopLevelMenu();
    }

    public List<MenuItem> getSecondLevelMenu(MenuItem mi) {
        return menuItemDao.getSecondLevelMenu(mi);
    }
}
