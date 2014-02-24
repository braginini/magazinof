package ru.ncideas.magazinof.gwt.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.ncideas.magazinof.gwt.exceptions.PasswordNotFoundException;
import ru.ncideas.magazinof.gwt.exceptions.UsernameNotFoundException;

@RemoteServiceRelativePath("RpcAuthenticationService")
public interface RpcAuthenticationService extends RemoteService {

    public Boolean authenticate()
            throws UsernameNotFoundException, PasswordNotFoundException;

    public Boolean isAuthenticated();

    public static class App {
        private static RpcAuthenticationServiceAsync instance = GWT.create(RpcAuthenticationService.class);

        public static synchronized RpcAuthenticationServiceAsync getInstance() {
            return instance;
        }
    }
}
