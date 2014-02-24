package ru.ncideas.magazinof.dao.impl.springjdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.MenuItem;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: mbragin
 * Date: 11.03.12
 * Time: 18:17
 */
public class MenuItemRowMapper implements RowMapper<MenuItem> {
    @Override
    public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        MenuItem menuItem = new MenuItem();

        menuItem.setId(rs.getLong("id"));
        menuItem.setName(rs.getString("name"));
        menuItem.setVisible(rs.getBoolean("visible"));
        menuItem.setParentId(rs.getLong("parent_id"));
        return menuItem;
    }

}
