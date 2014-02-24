package ru.ncideas.magazinof.dao.impl.springjdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.entity.Organization;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * magazinof.com
 * User: mbragin
 * Date: 09.03.12
 * Time: 23:04
 */
public class OrganizationRowMapper implements RowMapper<Organization> {
    @Override
    public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
        Organization organization = new Organization();

        organization.setId(rs.getLong("id"));
        organization.setAccount(new Account(rs.getLong("account_id")));
        organization.setDescription(rs.getString("description"));
        organization.setName(rs.getString("name"));

        return organization;
    }
}
