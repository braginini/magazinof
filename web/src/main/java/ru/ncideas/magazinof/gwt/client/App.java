package ru.ncideas.magazinof.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.Mvp4gModule;
import ru.ncideas.magazinof.gwt.client.dto.MenuItemDto;
import ru.ncideas.magazinof.gwt.client.registry.Registry;
import ru.ncideas.magazinof.gwt.client.registry.RegistryConstants;
import ru.ncideas.magazinof.gwt.client.services.RpcAuthenticationService;
import ru.ncideas.magazinof.gwt.client.services.RpcMenuService;
import ru.ncideas.magazinof.gwt.util.MenuEnum;

import java.util.ArrayList;
import java.util.List;

public class App implements EntryPoint {

    public void onModuleLoad() {
        init();
    }

    private void init() {
        RpcAuthenticationService.App.getInstance().authenticate(new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(Boolean result) {
                initMenu();
            }
        });
    }

    private void initMenu() {
        RpcMenuService.App.getInstance().getTopLevelMenu(new AsyncCallback<List<MenuItemDto>>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(List<MenuItemDto> result) {
                initStaticMenu(result);

                Mvp4gModule module = (Mvp4gModule) GWT.create(Mvp4gModule.class);
                module.createAndStartModule();
                RootLayoutPanel.get().add((Widget) module.getStartView());
                RootPanel.get("loading").setVisible(false);
            }
        });
    }

    private void initStaticMenu(List<MenuItemDto> menuItems) {
        List<MenuEnum> topLevelMenu = new ArrayList<MenuEnum>();
        for (MenuItemDto mi : menuItems) {
            MenuEnum me = MenuEnum.getByMenuItem(mi);
            topLevelMenu.add(me);
            List<MenuEnum> meList = new ArrayList<MenuEnum>();
            for (MenuItemDto miChild : mi.getChildList()) {
                meList.add(MenuEnum.getByMenuItem(miChild));
            }
            Registry.register(RegistryConstants.SECOND_LEVEL_MENU + me.name(), meList);
        }
        Registry.register(RegistryConstants.TOP_LEVEL_MENU, topLevelMenu);
    }

}
