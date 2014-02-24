package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.CustomerDao;
import ru.ncideas.magazinof.dao.OrderDao;
import ru.ncideas.magazinof.dao.OrderStatusDao;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.OrderRowMapper;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.extended.OrderRowMapperExt1;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.extended.OrderRowMapperExt2;
import ru.ncideas.magazinof.entity.Order;
import ru.ncideas.magazinof.entity.Organization;

import java.util.List;

//created by m.bragin
@Service
public class OrderDaoSpringJdbcImpl extends AbstractSpringJdbc implements OrderDao {

    private static final String tableName = "orders";
    private static final String orderStatusTableName = "order_statuses";
    private static final String customerTableName = "customers";
    private static final String deliveryTypeTableName = "delivery_types";
    private static final String addressTableName = "addresses";

    @Autowired
    CustomerDao customerDao;

    @Autowired
    OrderStatusDao orderStatusDao;

    @Override
    public List<Order> findOrdersByOrganization(Organization organization) {
        List<Order> orders = getNamedJdbcTemplate().query("SELECT * FROM " + tableName + " " +
                "WHERE organization_id = :organization_id",
                new MapSqlParameterSource("organization_id", organization.getId()),
                new OrderRowMapper());

        return orders;
    }

    @Override
    public List<Order> findOrdersByOrganizationExt(Organization organization) {

        List<Order> orders = getNamedJdbcTemplate().query("SELECT " +
                "o.*, " +
                "s.id AS order_status_id, " +
                "s.name AS order_status_name, " +
                "c.id AS customer_id, " +
                "c.first_name AS customer_first_name, " +
                "c.last_name AS customer_last_name " +
                "FROM " + tableName + " o " +
                "JOIN " + orderStatusTableName + " s ON o.status_id = s.id " +
                "JOIN " + customerTableName + "  c ON o.customer_id = c.id " +
                "WHERE o.organization_id = :organization_id",
                new MapSqlParameterSource("organization_id", organization.getId()),
                new OrderRowMapperExt1());

        return orders;

    }

    @Override
    public Long saveOrder(Order order) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void deleteOrder(Order order) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void updateOrder(Order order) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public Order findOrderById(Long id) {
        try {
            Order order = getNamedJdbcTemplate().queryForObject("SELECT o.*, " +
                    "s.id AS order_status_id, " +
                    "s.name AS order_status_name, " +
                    "c.id AS customer_id, " +
                    "c.first_name AS customer_first_name, " +
                    "c.last_name AS customer_last_name, " +
                    "d.name AS delivery_type, " +
                    "a.address AS address " +
                    "FROM " + tableName + " o " +
                    "LEFT JOIN " + orderStatusTableName + " s ON o.status_id = s.id " +
                    "LEFT JOIN " + customerTableName + "  c ON o.customer_id = c.id " +
                    "LEFT JOIN " + addressTableName + "  a ON o.address_id = a.id " +
                    "LEFT JOIN " + deliveryTypeTableName + " d ON o.delivery_type_id = d.id " +
                    "WHERE o.id = :id LIMIT 1",
                    new MapSqlParameterSource("id", id),
                    new OrderRowMapperExt2());

            return order;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
