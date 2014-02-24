package ru.ncideas.magazinof.dao.impl.springjdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.entity.User;
import ru.ncideas.magazinof.entity.UserStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * magazinof.com
 * User: mbragin
 * Date: 09.03.12
 * Time: 22:13
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setId(new Long(resultSet.getLong("id")));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        Timestamp ll = resultSet.getTimestamp("last_logged");
        user.setLastLogged(ll == null ? null : new Date(ll.getTime()));
        Timestamp cr = resultSet.getTimestamp("created");
        user.setCreated(cr == null ? null : new Date(cr.getTime()));
        user.setFirst_name(resultSet.getString("first_name"));
        user.setLast_name(resultSet.getString("last_name"));


        user.setAccount(new Account(resultSet.getLong("account_id")));
        user.setStatus(new UserStatus(resultSet.getLong("status_id")));

        return user;
    }
}
