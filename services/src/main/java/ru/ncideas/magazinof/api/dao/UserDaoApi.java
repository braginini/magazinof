package ru.ncideas.magazinof.api.dao;

import ru.ncideas.magazinof.api.domain.User;

import java.util.List;

/**
 * User: mbragin
 * Date: 28.04.12
 * Time: 15:35
 */
public interface UserDaoApi {

    User getUserById(long id);

    List<User> getAllUsers();
}
