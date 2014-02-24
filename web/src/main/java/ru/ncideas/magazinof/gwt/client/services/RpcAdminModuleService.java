package ru.ncideas.magazinof.gwt.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.gwt.client.dto.AccountDto;
import ru.ncideas.magazinof.gwt.client.dto.OrganizationDto;
import ru.ncideas.magazinof.gwt.client.dto.UserDto;

import java.util.List;

@RemoteServiceRelativePath("RpcAdminModuleService")
public interface RpcAdminModuleService extends RemoteService {

    public List<UserDto> findUsersByAccount(AccountDto accountDto) throws IllegalArgumentException;

    public List<OrganizationDto> findOrganizationsByAccount(AccountDto accountDto) throws IllegalArgumentException;

    public List<OrganizationDto> findOrganizationsByUser(UserDto userDto) throws IllegalArgumentException;

    public Long saveOrganization(OrganizationDto organizationDto) throws IllegalArgumentException;

    public void deleteOrganization(OrganizationDto organizationDto) throws IllegalArgumentException;

    public void deleteUser(UserDto userDto) throws IllegalArgumentException;

    public Long saveUser(UserDto userDto) throws IllegalArgumentException;

    public static class App {
        private static RpcAdminModuleServiceAsync instance = GWT.create(RpcAdminModuleService.class);

        public static synchronized RpcAdminModuleServiceAsync getInstance() {
            return instance;
        }
    }
}
