package ru.ncideas.magazinof.dao;

import ru.ncideas.magazinof.entity.Address;

import java.util.List;

public interface AddressDao {

    public List<Address> findPhonesByPerson(Long personId);
}
