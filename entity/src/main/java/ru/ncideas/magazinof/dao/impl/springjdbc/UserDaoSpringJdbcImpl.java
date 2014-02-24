package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.UserDao;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.extended.UserRowMapperExt;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.UserRowMapper;
import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.entity.User;

import java.util.List;

@Service
public class UserDaoSpringJdbcImpl extends AbstractSpringJdbc implements UserDao {

    private static final String tableName = "users";
    private static final  String userStatusesTableName = "user_statuses";
    private static final  String tableSequence = "user_id_seq";

    public User findUserByUsername(String username) throws EmptyResultDataAccessException {
        try {
            return getNamedJdbcTemplate().queryForObject("SELECT * FROM " + tableName +
                " WHERE username = :username", new MapSqlParameterSource("username", username),
                new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
			return null;
		}
    }

    public List<User> findUsersByAccount(Account account) {
        return getNamedJdbcTemplate().query("SELECT " +
                "u.id AS user_id, " +
                "u.created AS user_created, " +
                "u.username AS user_username, " +
                "u.last_logged AS user_last_logged, " +
                "u.account_id AS account_id, " +
                "us.id AS user_status_id, " +
                "us.name AS user_status_name, " +
                "u.first_name AS first_name, " +
                "u.last_name AS last_name, " +
                "u.email AS email " +
                "FROM " + tableName + " u " +
                "JOIN " + userStatusesTableName + " us ON u.status_id = us.id " +
                " WHERE account_id = :account_id", new MapSqlParameterSource("account_id", account.getId()),
                new UserRowMapperExt());
    }

    public void deleteUser(User user) {
        //TODO delete cascade
        getNamedJdbcTemplate().update("DELETE FROM " + tableName + " WHERE id = :id",
                new MapSqlParameterSource("id", user.getId()));
    }


    public Long saveUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        if (user.getId() == null) {
            getNamedJdbcTemplate().update("INSERT INTO " + tableName + " (id, created, username, password" +
                    "last_logged, account_id, status_id )" +
                    "VALUES (nextval(" + tableSequence + "), " +     //id from sequence
                    ":created, " +
                    ":username," +
                    ":password," +
                    ":lastLogged," +
                    ":accountId," +
                    ":statusId)",
                    new MapSqlParameterSource()
                            .addValue("created", user.getCreated())
                            .addValue("username", user.getUsername())
                            .addValue("password", user.getPassword())
                            .addValue("lastLogged", user.getLastLogged())
                            .addValue("accountId", user.getAccount().getId())
                            .addValue("statusId", user.getStatus().getId()));
            user.setId(keyHolder.getKey().longValue());
        } else {
            updateUser(user);
        }
        return user.getId();
    }

    @Override
    public void updateUser(User user) {
        getNamedJdbcTemplate().update("UPDATE " + tableName + " SET " +
                "created = :created, " +
                "username = :username, " +
                "password = :password, " +
                "last_logged = :lastLogged, " +
                "account_id = :accountId, " +
                "status_id = :statusId " +
                "WHERE id = :id",
                new MapSqlParameterSource()
                            .addValue("id", user.getId())
                            .addValue("created", user.getCreated())
                            .addValue("username", user.getUsername())
                            .addValue("password", user.getPassword())
                            .addValue("lastLogged", user.getLastLogged())
                            .addValue("accountId", user.getAccount().getId())
                            .addValue("statusId", user.getStatus().getId()));
    }
}
