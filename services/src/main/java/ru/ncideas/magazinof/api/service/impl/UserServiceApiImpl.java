package ru.ncideas.magazinof.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.api.dao.UserDaoApi;
import ru.ncideas.magazinof.api.domain.User;
import ru.ncideas.magazinof.api.service.UserServiceApi;

import java.util.List;

/**
 * User: mbragin
 * Date: 28.04.12
 * Time: 15:36
 */
@Service
public class UserServiceApiImpl implements UserServiceApi {

    @Autowired
    UserDaoApi userDaoApi;

    public User getUserById(long id) {
        return userDaoApi.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoApi.getAllUsers();
    }
}
