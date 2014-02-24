package ru.ncideas.magazinof.dao.impl.springjdbc.mapper.extended;

import org.springframework.jdbc.core.RowMapper;
import ru.ncideas.magazinof.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/*
 * @author: mbragin
 */
public class OrderRowMapperExt1 implements RowMapper<Order> {
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

        return order;
    }

    private Address createAddress(ResultSet rs) throws SQLException {
        Address address = null;
        try {
            address.setId(rs.getLong("address_id"));
            address.setAddress(rs.getString("address"));
        } catch (NullPointerException e) {

        }
        return address;
    }

    private Customer createCustomer(ResultSet rs) throws SQLException {
        Customer customer = new Customer();

        customer.setId(rs.getLong("customer_id"));
        customer.setFirstName(rs.getString("customer_first_name"));
        customer.setLastName(rs.getString("customer_last_name"));

        return customer;
    }

    /*private Person createPerson(ResultSet rs) throws SQLException {
        Person person = new Person();

        person.setId(rs.getLong("person_id"));
        person.setFirstName(rs.getString("person_first_name"));
        person.setLastName(rs.getString("person_last_name"));

        return person;
    }*/

    private OrderStatus createOrderStatus(ResultSet rs) throws SQLException {
        OrderStatus orderStatus = new OrderStatus();

        orderStatus.setId(rs.getLong("order_status_id"));
        orderStatus.setName(rs.getString("order_status_name"));

        return orderStatus;
    }
}
