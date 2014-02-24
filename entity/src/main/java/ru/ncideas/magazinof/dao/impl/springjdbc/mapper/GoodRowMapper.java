package ru.ncideas.magazinof.dao.impl.springjdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.Good;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: mbragin
 * Date: 07.06.12
 * Time: 13:46
 */
public class GoodRowMapper implements RowMapper<Good> {
    @Override
    public Good mapRow(ResultSet rs, int rowNum) throws SQLException {
        Good good = new Good();

        good.setId(rs.getLong("id"));
        good.setArticle(rs.getString("article"));
        good.setDescription(rs.getString("description"));
        good.setName(rs.getString("name"));
        good.setAccountId(rs.getLong("account_id"));
        good.setMeasureId(rs.getLong("measure_id"));
        good.setOrganizationId(rs.getLong("organization_id"));

        return good;
    }
}
