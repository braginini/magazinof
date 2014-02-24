package ru.ncideas.magazinof.api.service;

import ru.ncideas.magazinof.api.domain.User;

import java.util.List;

/**
 * User: mbragin
 * Date: 28.04.12
 * Time: 15:36
 */
public interface UserServiceApi {

    User getUserById(long id);

    List<User> getAllUsers();
}
