package ru.ncideas.magazinof.api.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ncideas.magazinof.api.dao.UserDaoApi;
import ru.ncideas.magazinof.api.domain.User;
import ru.ncideas.magazinof.api.domain.UserDataBase;

import java.util.List;

/**
 * User: mbragin
 * Date: 28.04.12
 * Time: 15:36
 */
@Repository
public class UserDaoApiImpl implements UserDaoApi {

    @Autowired
    UserDataBase userDataBase;

    public User getUserById(long id) {
        return userDataBase.getUser(id);
    }

    public List<User> getAllUsers() {
        return userDataBase.getAllUsers();
    }
}
