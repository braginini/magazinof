package ru.ncideas.magazinof.gwt.server;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ncideas.magazinof.gwt.client.dto.AccountDto;
import ru.ncideas.magazinof.gwt.client.dto.OrganizationDto;
import ru.ncideas.magazinof.gwt.client.dto.UserDto;
import ru.ncideas.magazinof.gwt.client.registry.Registry;
import ru.ncideas.magazinof.gwt.client.registry.RegistryConstants;
import ru.ncideas.magazinof.gwt.client.services.RpcAdminModuleService;
import ru.ncideas.magazinof.gwt.util.AutoinjectingRemoteServiceServlet;
import ru.ncideas.magazinof.gwt.util.DozerGenerator;
import ru.ncideas.magazinof.services.OrganizationService;
import ru.ncideas.magazinof.services.UserService;

import java.util.List;

public class RpcAdminModuleServiceImpl extends AutoinjectingRemoteServiceServlet implements RpcAdminModuleService {

    @Autowired
    DozerBeanMapper mapper;

    @Autowired
    OrganizationService organizationService;

    @Autowired
    UserService userService;

    @Override
    public List<UserDto> findUsersByAccount(AccountDto accountDto) throws IllegalArgumentException {
        return DozerGenerator.appUserListEntityToDto(mapper, userService.findUsersByAccount(
                DozerGenerator.accountDtoToEntity(mapper, accountDto)));
    }

    @Override
    public List<OrganizationDto> findOrganizationsByAccount(AccountDto accountDto) throws IllegalArgumentException {
        return DozerGenerator.organizationListEntityToDto(mapper,
                organizationService.findOrganizationsByAccount(DozerGenerator.accountDtoToEntity(mapper, accountDto)));
    }

    @Override
    public List<OrganizationDto> findOrganizationsByUser(UserDto userDto) throws IllegalArgumentException {
        return DozerGenerator.organizationListEntityToDto(mapper,
                organizationService.findOrganizationsByUser(DozerGenerator.appUserDtoToEntity(mapper, userDto)));
    }

    @Override
    public Long saveOrganization(OrganizationDto organizationDto) throws IllegalArgumentException {
        if (organizationDto.getAccount() == null) {
            AccountDto account = Registry.get(RegistryConstants.ACCOUNT);
            organizationDto.setAccount(account);
        }
        return organizationService.saveOrganization(DozerGenerator.organizationDtoToEntity(mapper, organizationDto));
    }

    @Override
    public void deleteOrganization(OrganizationDto organizationDto) throws IllegalArgumentException {
        organizationService.deleteOrganization(DozerGenerator.organizationDtoToEntity(mapper, organizationDto));
    }

    @Override
    public void deleteUser(UserDto userDto) throws IllegalArgumentException {
        userService.deleteUser(DozerGenerator.appUserDtoToEntity(mapper, userDto));
    }

    @Override
    public Long saveUser(UserDto userDto) throws IllegalArgumentException {
        return userService.saveUser(DozerGenerator.appUserDtoToEntity(mapper, userDto));
    }
}
