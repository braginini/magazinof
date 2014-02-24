package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.OrganizationDao;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.OrganizationRowMapper;
import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.entity.Organization;
import ru.ncideas.magazinof.entity.User;

import java.util.List;

@Service
public class OrganizationDaoSpringJdbcImpl extends AbstractSpringJdbc implements OrganizationDao {

    private String tableName = "organizations";
    private String userTableName = "users";
    private String userRoleTableName = "users_roles";
    private String organizationRoleTableName = "organizations_roles";
    private String tableSequence = "organization_id_seq";

    public List<Organization> findOrganizationsByAccount(Account account) {
        List<Organization> organizations = getNamedJdbcTemplate().query("SELECT * FROM " + userTableName + " WHERE " +
                "account_id = :account_id", new MapSqlParameterSource("account_id", account.getId()),
                new OrganizationRowMapper());

        return organizations;
    }

    public List<Organization> findOrganizationsByUser(User user) {
        List<Organization> organizations = getNamedJdbcTemplate().query("Select DISTINCT o.* " +
                "FROM " + tableName + " org JOIN " +
                "(SELECT * FROM " + userRoleTableName + " user_role " +
                "JOIN " + organizationRoleTableName + " org_role " +
                "ON org_role.role_id = user_role.role_id) user_org ON org.id = user_org.organization_id " +
                "WHERE user_id = :user_id", new MapSqlParameterSource("user_id", user.getId()),
                new OrganizationRowMapper());

        return organizations;
    }

    public Long saveOrganization(Organization org) {
        int orgId = -1;
        if (org.getId() == null) {
            orgId = getNamedJdbcTemplate().update("INSERT INTO " + tableName + " (id, account_id, description, name " +
                    "VALUES (nextval(" + tableSequence + "), " +     //id from sequence
                    ":account_id, " +
                    ":description," +
                    ":name,",
                    new MapSqlParameterSource()
                            .addValue("account_id", org.getAccount().getId())
                            .addValue("active", org.getDescription())
                            .addValue("username", org.getName()));
            org.setId(new Long(orgId));
        } else {
            updateOrganization(org);
        }
        return org.getId();
    }

    public void updateOrganization(Organization org) {
        getNamedJdbcTemplate().update("UPDATE " + tableName + "SET " +
                "account_id = :account_id, " +
                "description = :description," +
                "name = :name,",
                new MapSqlParameterSource()
                        .addValue("account_id", org.getAccount().getId())
                        .addValue("active", org.getDescription())
                        .addValue("username", org.getName()));
    }

    public void deleteOrganization(Organization org) {
        //todo DELETE CASCADE else an error with foreign key will take place
        getNamedJdbcTemplate().update("DELETE FROM " + tableName + " WHERE id = :id",
                new MapSqlParameterSource("id", org.getId()));
    }


}
