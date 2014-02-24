package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.AddressDao;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.AddressRowMapper;
import ru.ncideas.magazinof.entity.Address;

import java.util.List;

@Service
public class AddressDaoSpringJdbcImpl extends AbstractSpringJdbc implements AddressDao {

    private static final String tableName = "addresses";
    private static final String personsAddressesTableName = "persons_addresses";

    @Override
    public List<Address> findPhonesByPerson(Long personId) {
        return getNamedJdbcTemplate().query("SELECT * FROM " + tableName + " a " +
                "JOIN " + personsAddressesTableName + " pa ON pa.address_id = a.id " +
                "WHERE pp.person_id = :personId",
                new MapSqlParameterSource("personId", personId),
                new AddressRowMapper());
    }
}
