package ru.ncideas.magazinof.dao;

import ru.ncideas.magazinof.entity.*;

import java.util.List;

public interface UserDao {

    public User findUserByUsername(String username);
    public List<User> findUsersByAccount(Account account);
    public void deleteUser(User user);
    public Long saveUser(User user);
    public void updateUser(User user);
}
