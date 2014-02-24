package ru.ncideas.magazinof.dao.impl.springjdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.OrderStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: mbragin
 * Date: 12.03.12
 * Time: 11:16
 */
public class OrderStatusRowMapper implements RowMapper<OrderStatus> {
    @Override
    public OrderStatus mapRow(ResultSet rs, int rowNum) throws SQLException {

        OrderStatus orderStatus = new OrderStatus();

        orderStatus.setId(rs.getLong("id"));
        orderStatus.setName(rs.getString("name"));

        return orderStatus;
    }
}
