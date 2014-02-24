package ru.ncideas.magazinof.dao.impl.springjdbc.mapper.extended;

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
public class UserRowMapperExt implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setId(resultSet.getLong("user_id"));
        user.setUsername(resultSet.getString("user_username"));
        Timestamp ll = resultSet.getTimestamp("user_last_logged");
        user.setLastLogged(ll == null ? null : new Date(ll.getTime()));
        Timestamp cr = resultSet.getTimestamp("user_created");
        user.setCreated(cr == null ? null : new Date(cr.getTime()));
        user.setAccount(new Account(resultSet.getLong("account_id")));
        user.setFirst_name(resultSet.getString("first_name"));
        user.setLast_name(resultSet.getString("last_name"));
        user.setEmail(resultSet.getString("email"));

        user.setStatus(createStatus(resultSet));

        return user;
    }

   /* private Person createPerson(ResultSet resultSet) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getLong("person_id"));
        person.setFirstName(resultSet.getString("person_first_name"));
        person.setLastName(resultSet.getString("person_last_name"));
        person.setEmail(resultSet.getString("person_email"));

        return person;
    }*/

    private UserStatus createStatus(ResultSet resultSet) throws SQLException {
        UserStatus status = new UserStatus();

        status.setId(resultSet.getLong("user_status_id"));
        status.setName(resultSet.getString("user_status_name"));

        return status;
    }
}
