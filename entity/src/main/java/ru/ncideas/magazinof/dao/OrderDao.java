package ru.ncideas.magazinof.dao;

import ru.ncideas.magazinof.entity.Order;
import ru.ncideas.magazinof.entity.Organization;

import java.util.List;

//created by m.bragin
public interface OrderDao {

    List<Order> findOrdersByOrganization(Organization organization);

    List<Order> findOrdersByOrganizationExt(Organization organization);

    Long saveOrder(Order order);

    void deleteOrder(Order order);

    void updateOrder(Order order);

    Order findOrderById(Long id);
}
