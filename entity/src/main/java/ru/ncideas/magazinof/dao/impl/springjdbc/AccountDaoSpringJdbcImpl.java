package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.AccountDao;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.AccountRowMapper;
import ru.ncideas.magazinof.entity.Account;

@Service
public class AccountDaoSpringJdbcImpl extends AbstractSpringJdbc implements AccountDao {

    private String tableName = "accounts";
    private String tableSequence = "account_id_seq";

    public Account findAccount(long accountId) throws EmptyResultDataAccessException {
            try {
                return getNamedJdbcTemplate().queryForObject("SELECT * FROM " + tableName +
                    " WHERE id = :accountId", new MapSqlParameterSource("accountId", accountId),
                    new AccountRowMapper());
            } catch (EmptyResultDataAccessException e) {
    			return null;
    		}
        }

}
