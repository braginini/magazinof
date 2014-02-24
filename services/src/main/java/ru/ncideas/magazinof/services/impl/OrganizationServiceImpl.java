package ru.ncideas.magazinof.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.OrganizationDao;
import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.entity.Organization;
import ru.ncideas.magazinof.entity.User;
import ru.ncideas.magazinof.services.OrganizationService;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    //todo catch EmptyResultDataException thrown by spring to all methods

    @Autowired
    OrganizationDao orgDao;

    public Long saveOrganization(Organization org) {
        return orgDao.saveOrganization(org);
    }

    @Override
    public void deleteOrganization(Organization org) {
        orgDao.deleteOrganization(org);
    }

    @Override
    public List<Organization> findOrganizationsByAccount(Account account) {
        return orgDao.findOrganizationsByAccount(account);
    }

    @Override
    public List<Organization> findOrganizationsByUser(User user) {
        return orgDao.findOrganizationsByUser(user);
    }
}
