package ru.ncideas.magazinof.dao.impl.springjdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * User: mbragin
 * Date: 11.03.12
 * Time: 17:56
 */
public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int i) throws SQLException {
        Order order = new Order();

        order.setAddress(new Address(rs.getLong("address_id")));
        order.setPhone(new Phone(rs.getLong("phone_id")));
        order.setCustomer(new Customer(rs.getLong("customer_id")));
        Timestamp dd = rs.getTimestamp("delivery_date");
        order.setDeliveryDate(dd == null ? null : new Date(dd.getTime()));
        order.setDeliveryType(new DeliveryType(rs.getLong("delivery_type_id")));
        order.setEmployee(new User(rs.getLong("user_id")));
        order.setId(rs.getLong("id"));
        Timestamp od = rs.getTimestamp("order_date");
        order.setOrderDate(od == null ? null : new Date(od.getTime()));
        order.setOrderNumber(rs.getString("order_number"));
        order.setOrganization(new Organization(rs.getLong("organization_id")));
        order.setStatus(new OrderStatus(rs.getLong("status_id")));

        return order;
    }
}
