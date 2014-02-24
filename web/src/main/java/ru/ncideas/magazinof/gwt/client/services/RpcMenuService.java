package ru.ncideas.magazinof.gwt.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.ncideas.magazinof.gwt.client.dto.MenuItemDto;
import ru.ncideas.magazinof.gwt.client.dto.UserDto;

import java.io.Serializable;
import java.util.List;

@RemoteServiceRelativePath("RpcMenuService")
public interface RpcMenuService extends RemoteService {

    public List<MenuItemDto> getTopLevelMenu();

    public static class App {
        private static RpcMenuServiceAsync instance = GWT.create(RpcMenuService.class);

        public static synchronized RpcMenuServiceAsync getInstance() {
            return instance;
        }
    }

}
