package ru.ncideas.magazinof.services;

import ru.ncideas.magazinof.entity.*;

import java.util.List;

public interface OrganizationService {

    Long saveOrganization(Organization org);

    void deleteOrganization(Organization org);

    List<Organization> findOrganizationsByAccount(Account account);

    List<Organization> findOrganizationsByUser(User user);
}
