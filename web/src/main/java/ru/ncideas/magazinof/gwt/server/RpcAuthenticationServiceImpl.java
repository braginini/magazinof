package ru.ncideas.magazinof.gwt.server;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ncideas.magazinof.gwt.client.dto.AccountDto;
import ru.ncideas.magazinof.gwt.client.dto.UserDto;
import ru.ncideas.magazinof.gwt.client.registry.Registry;
import ru.ncideas.magazinof.gwt.client.registry.RegistryConstants;
import ru.ncideas.magazinof.gwt.client.services.RpcAuthenticationService;
import ru.ncideas.magazinof.gwt.exceptions.PasswordNotFoundException;
import ru.ncideas.magazinof.gwt.exceptions.UsernameNotFoundException;
import ru.ncideas.magazinof.gwt.util.AutoinjectingRemoteServiceServlet;
import ru.ncideas.magazinof.security.CustomUserAuthentication;
import ru.ncideas.magazinof.services.AuthenticationService;
import ru.ncideas.magazinof.services.SessionService;

public class RpcAuthenticationServiceImpl extends AutoinjectingRemoteServiceServlet implements RpcAuthenticationService {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    SessionService sessionService;

    @Autowired
    DozerBeanMapper mapper;

    public Boolean authenticate()
            throws UsernameNotFoundException, PasswordNotFoundException {
        CustomUserAuthentication cua = sessionService.getAuthentication();
        if (cua.getUser() == null) {
            throw new UsernameNotFoundException((String) sessionService.getAttribute("requestUsername"));
        } else if (!cua.isAuthenticated()) {
            throw new PasswordNotFoundException((String) sessionService.getAttribute("requestUsername"));
        }

        Registry.register(RegistryConstants.USER, mapper.map(sessionService.getUser(), UserDto.class));
        AccountDto acc = mapper.map(sessionService.getAccount(), AccountDto.class);
        Registry.register(RegistryConstants.ACCOUNT, acc);
        return true;
    }

    public Boolean isAuthenticated() {
        return sessionService.isAuthenticated();
    }
}