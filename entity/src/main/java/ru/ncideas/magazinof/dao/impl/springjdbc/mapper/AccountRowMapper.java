package ru.ncideas.magazinof.dao.impl.springjdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 16:41
 */
public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();

        account.setId(new Long(resultSet.getLong("id")));
        account.setName(resultSet.getString("name"));

        return account;
    }
}
