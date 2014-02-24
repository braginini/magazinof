package ru.ncideas.magazinof.services;

import ru.ncideas.magazinof.entity.Order;
import ru.ncideas.magazinof.entity.Organization;

import java.util.List;

//created by m.bragin
public interface OrderService {

    List<Order> findOrdersByOrganization(Organization organization);

    List<Order> findOrdersByOrganizationExt(Organization organization);

    Order findOrderById(Long id);
}
