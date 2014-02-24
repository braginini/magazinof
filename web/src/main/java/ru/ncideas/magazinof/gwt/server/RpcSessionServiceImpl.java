package ru.ncideas.magazinof.gwt.server;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ncideas.magazinof.gwt.client.dto.AccountDto;
import ru.ncideas.magazinof.gwt.client.dto.UserDto;
import ru.ncideas.magazinof.gwt.client.registry.Registry;
import ru.ncideas.magazinof.gwt.client.registry.RegistryConstants;
import ru.ncideas.magazinof.gwt.client.services.RpcSessionService;
import ru.ncideas.magazinof.gwt.util.AutoinjectingRemoteServiceServlet;
import ru.ncideas.magazinof.gwt.util.DozerGenerator;
import ru.ncideas.magazinof.services.AuthenticationService;
import ru.ncideas.magazinof.services.SessionService;

public class RpcSessionServiceImpl extends AutoinjectingRemoteServiceServlet implements RpcSessionService {

    @Autowired
    SessionService sessionService;

    @Autowired
    DozerBeanMapper mapper;

    @Autowired
    AuthenticationService authenticationService;

    public UserDto getUser() {
        return DozerGenerator.appUserEntityToDto(mapper, sessionService.getUser());
    }

    public AccountDto getAccount() {
        return DozerGenerator.accountEntityToDto(mapper, sessionService.getAccount());
    }

    public Boolean isAuthenticated() {
        return sessionService.isAuthenticated();
    }

    public void logout() {
        Registry.unregister(RegistryConstants.USER);
        sessionService.logout();
    }
}
