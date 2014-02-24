package ru.ncideas.magazinof.dao.impl.springjdbc.mapper.extended;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * User: mbragin
 * Date: 28.05.12
 * Time: 13:29
 */
public class OrderRowMapperExt2 implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();

        Timestamp dd = rs.getTimestamp("delivery_date");
        order.setDeliveryDate(dd == null ? null : new Date(dd.getTime()));
        order.setId(rs.getLong("id"));
        Timestamp od = rs.getTimestamp("order_date");
        order.setOrderDate(od == null ? null : new Date(od.getTime()));
        order.setOrderNumber(rs.getString("order_number"));

        order.setStatus(createOrderStatus(rs));
        order.setCustomer(createCustomer(rs));

        //not common fields for all queries
        order.setAddress(createAddress(rs));
        order.setDeliveryType(createDeliveryType(rs));

        return order;
    }

    private DeliveryType createDeliveryType(ResultSet rs) throws SQLException {
        DeliveryType deliveryType = new DeliveryType();
        deliveryType.setId(rs.getLong("delivery_type_id"));
        deliveryType.setName(rs.getString("delivery_type"));
        return deliveryType;
    }

    private Address createAddress(ResultSet rs) throws SQLException {
        Address address = new Address();
        address.setId(rs.getLong("address_id"));
        address.setAddress(rs.getString("address"));
        return address;
    }

    private Customer createCustomer(ResultSet rs) throws SQLException {
        Customer customer = new Customer();

        customer.setId(rs.getLong("customer_id"));
        customer.setFirstName(rs.getString("customer_first_name"));
        customer.setLastName(rs.getString("customer_last_name"));

        return customer;
    }

    private OrderStatus createOrderStatus(ResultSet rs) throws SQLException {
        OrderStatus orderStatus = new OrderStatus();

        orderStatus.setId(rs.getLong("order_status_id"));
        orderStatus.setName(rs.getString("order_status_name"));

        return orderStatus;
    }
}

