package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.OrderStatusDao;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.OrderStatusRowMapper;
import ru.ncideas.magazinof.entity.OrderStatus;

/**
 * User: mbragin
 * Date: 12.03.12
 * Time: 11:14
 */
@Service
public class OrderStatusDaoSpringJdbc extends AbstractSpringJdbc implements OrderStatusDao {

    private String tableName = "order_statuses";

    @Override
    public OrderStatus findStatusById(Long id) {

        OrderStatus orderStatus = getNamedJdbcTemplate().queryForObject("SELECT * FROM " + tableName + " WHERE id = :id",
                new MapSqlParameterSource("id", id),
                new OrderStatusRowMapper());

        return orderStatus;
    }
}
