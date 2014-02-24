package ru.ncideas.magazinof.dao.impl.springjdbc.mapper.extended;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.Good;
import ru.ncideas.magazinof.entity.Measure;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: mbragin
 * Date: 07.06.12
 * Time: 17:46
 */
public class GoodRowMapperExt implements RowMapper<Good> {

    @Override
    public Good mapRow(ResultSet rs, int rowNum) throws SQLException {
        Good good = new Good();

        good.setId(rs.getLong("id"));
        good.setArticle(rs.getString("article"));
        good.setDescription(rs.getString("description"));
        good.setName(rs.getString("name"));
        good.setAccountId(rs.getLong("account_id"));

        good.setMeasureId(rs.getLong("measure_id"));
        if (!rs.wasNull()) {
            good.setMeasure(new Measure(rs.getLong("measure_id"), rs.getString("measure_name"), rs.getLong("account_id")));
        } else good.setMeasureId(null);

        good.setOrganizationId(rs.getLong("organization_id"));


        return good;
    }
}
