package ru.ncideas.magazinof.dao;

import ru.ncideas.magazinof.entity.Phone;

import java.util.List;

public interface PhoneDao {

    List<Phone> findPhonesByPerson(Long customerId);
}
