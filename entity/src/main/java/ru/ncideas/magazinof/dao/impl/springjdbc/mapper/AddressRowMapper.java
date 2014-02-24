package ru.ncideas.magazinof.dao.impl.springjdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: mbragin
 * Date: 12.03.12
 * Time: 11:47
 */
public class AddressRowMapper implements RowMapper<Address> {
    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address address = new Address();

        address.setId(rs.getLong("id"));
        address.setAddress(rs.getString("address"));

        return address;

    }
}
