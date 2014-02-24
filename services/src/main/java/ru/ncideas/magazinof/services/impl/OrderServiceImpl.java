package ru.ncideas.magazinof.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.OrderDao;
import ru.ncideas.magazinof.entity.Order;
import ru.ncideas.magazinof.entity.Organization;
import ru.ncideas.magazinof.services.OrderService;

import java.util.List;

//created by m.bragin
@Service
public class OrderServiceImpl implements OrderService {

    //todo catch EmptyResultDataException thrown by spring to all methods

    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> findOrdersByOrganization(Organization organization) {
        return orderDao.findOrdersByOrganization(organization);
    }

    @Override
    public List<Order> findOrdersByOrganizationExt(Organization organization) {
        return orderDao.findOrdersByOrganizationExt(organization);
    }

    @Override
    public Order findOrderById(Long id) {
        return orderDao.findOrderById(id);
    }
}
