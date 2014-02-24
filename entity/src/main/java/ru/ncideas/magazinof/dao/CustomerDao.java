package ru.ncideas.magazinof.dao;

import ru.ncideas.magazinof.entity.Customer;

/**
 * User: mbragin
 * Date: 12.03.12
 * Time: 10:58
 */
public interface CustomerDao {

    Customer findCustomerById(Long id);
}
