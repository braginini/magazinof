package ru.ncideas.magazinof.dao;

import ru.ncideas.magazinof.entity.OrderStatus;

/**
 * User: mbragin
 * Date: 12.03.12
 * Time: 11:14
 */
public interface OrderStatusDao {

    OrderStatus findStatusById(Long id);
}
