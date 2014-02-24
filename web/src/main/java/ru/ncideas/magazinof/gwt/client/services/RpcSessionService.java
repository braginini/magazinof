package ru.ncideas.magazinof.gwt.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.ncideas.magazinof.gwt.client.dto.AccountDto;
import ru.ncideas.magazinof.gwt.client.dto.UserDto;

import java.io.Serializable;

@RemoteServiceRelativePath("RpcSessionService")
public interface RpcSessionService extends RemoteService {

    public UserDto getUser();

    public AccountDto getAccount();

    public Boolean isAuthenticated();

    public void logout();

    public static class App {
        private static RpcSessionServiceAsync instance = GWT.create(RpcSessionService.class);

        public static synchronized RpcSessionServiceAsync getInstance() {
            return instance;
        }
    }

}
