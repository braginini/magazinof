package ru.ncideas.magazinof.dao.impl.springjdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.Phone;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: mbragin
 * Date: 12.03.12
 * Time: 12:04
 */
public class PhoneRowMapper implements RowMapper<Phone> {
    @Override
    public Phone mapRow(ResultSet rs, int rowNum) throws SQLException {
        Phone phone = new Phone();

        phone.setId(rs.getLong("id"));
        phone.setPhone(rs.getString("phone"));

        return phone;
    }
}
