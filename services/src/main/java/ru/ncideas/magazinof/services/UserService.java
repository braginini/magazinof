package ru.ncideas.magazinof.services;

import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.entity.User;

import java.util.List;

public interface UserService {

    public User findUserByUsername(String username);
    public List<User> findUsersByAccount(Account account);
    public void deleteUser(User user);
    public Long saveUser(User user);
}
