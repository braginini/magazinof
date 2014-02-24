package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * User: mbragin
 * Date: 06.03.12
 * Time: 16:41
 */
abstract public class AbstractSpringJdbc {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    protected NamedParameterJdbcTemplate getNamedJdbcTemplate() {
        return namedJdbcTemplate;
    }

    protected JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
