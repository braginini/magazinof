package ru.ncideas.magazinof.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.UserDao;
import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.entity.User;
import ru.ncideas.magazinof.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    //todo catch EmptyResultDataException thrown by spring to all methods
    @Autowired
    UserDao userDao;

    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public List<User> findUsersByAccount(Account account) {
        return userDao.findUsersByAccount(account);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public Long saveUser(User user) {
        return userDao.saveUser(user);
    }

}
