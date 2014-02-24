package ru.ncideas.magazinof.dao;

import ru.ncideas.magazinof.entity.*;

import java.util.List;

public interface OrganizationDao {

    List<Organization> findOrganizationsByAccount(Account accountDto);

    Long saveOrganization(Organization org);

    void deleteOrganization(Organization org);

    List<Organization> findOrganizationsByUser(User user);

    void updateOrganization(Organization org);
}
