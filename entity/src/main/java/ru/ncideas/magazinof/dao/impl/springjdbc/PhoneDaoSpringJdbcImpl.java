package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.PhoneDao;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.PhoneRowMapper;import ru.ncideas.magazinof.entity.Phone;

import java.util.List;

@Service
public class PhoneDaoSpringJdbcImpl extends AbstractSpringJdbc implements PhoneDao {

    private static final String tableName = "phones";
    private static final String personsPhonesTableName = "persons_phones";

    @Override
    public List<Phone> findPhonesByPerson(Long customerId) {
        return getNamedJdbcTemplate().query("SELECT * FROM " + tableName + " p " +
                "JOIN " + personsPhonesTableName + " pp ON pp.phone_id = p.id " +
                "WHERE pp.person_id = :personId",
                new MapSqlParameterSource("personId", customerId),
                new PhoneRowMapper());
    }
}
