package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.AddressDao;
import ru.ncideas.magazinof.dao.CustomerDao;
import ru.ncideas.magazinof.dao.PhoneDao;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.CustomerRowMapper;
import ru.ncideas.magazinof.entity.Customer;

/**
 * User: mbragin
 * Date: 12.03.12
 * Time: 11:04
 */
@Service
public class CustomerDaoSpringJdbcImpl extends AbstractSpringJdbc implements CustomerDao {

    private String tableName = "customers";

    @Autowired
    AddressDao addressDao;

    @Autowired
    PhoneDao phoneDao;

    @Override
    public Customer findCustomerById(Long id) {

        Customer customer = getNamedJdbcTemplate().queryForObject("SELECT * FROM " + tableName + " WHERE id = :id",
                new MapSqlParameterSource("id", id),
                new CustomerRowMapper());
        return customer;
    }

}
