package ru.ncideas.magazinof.dao.impl.springjdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.Measure;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: mbragin
 * Date: 14.06.12
 * Time: 17:24
 */
public class MeasureRowMapper implements RowMapper<Measure> {
    @Override
    public Measure mapRow(ResultSet rs, int rowNum) throws SQLException {
        Measure measure = new Measure(rs.getLong("id"), rs.getString("name"), rs.getLong("account_id"));
        return measure;
    }
}
