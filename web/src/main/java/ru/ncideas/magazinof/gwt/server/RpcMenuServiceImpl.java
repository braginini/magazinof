package ru.ncideas.magazinof.gwt.server;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.gwt.client.dto.MenuItemDto;
import ru.ncideas.magazinof.gwt.client.services.RpcMenuService;
import ru.ncideas.magazinof.gwt.util.Menu;
import ru.ncideas.magazinof.gwt.util.AutoinjectingRemoteServiceServlet;
import ru.ncideas.magazinof.gwt.util.DozerGenerator;
import ru.ncideas.magazinof.services.MenuItemService;

import java.util.List;

public class RpcMenuServiceImpl extends AutoinjectingRemoteServiceServlet implements RpcMenuService {

    @Autowired
    DozerBeanMapper mapper;

    @Autowired
    MenuItemService menuItemService;

    public List<MenuItemDto> getTopLevelMenu() {
        if (!Menu.initialized()) {
            List<MenuItemDto> dtos = DozerGenerator.menuItemListEntityToDto(mapper, menuItemService.getTopLevelMenu());
            Menu.setMenuItems(dtos);
            return dtos;
        }
        return Menu.getTopLevelMenu();
    }

}
