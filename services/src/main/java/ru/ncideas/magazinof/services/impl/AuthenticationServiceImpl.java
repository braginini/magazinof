package ru.ncideas.magazinof.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.AccountDao;
import ru.ncideas.magazinof.dao.UserDao;
import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.entity.User;
import ru.ncideas.magazinof.security.CustomUserAuthentication;
import ru.ncideas.magazinof.services.AuthenticationService;
import ru.ncideas.magazinof.services.SessionService;

import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    SessionService sessionService;

    @Autowired
    AccountDao accountDao;

    @Autowired
    UserDao userDao;

    public CustomUserAuthentication authenticate(String username, String password) {
        sessionService.setAttribute("requestUsername", username);
        User user = userDao.findUserByUsername(username);
        CustomUserAuthentication authentication = new CustomUserAuthentication(user);
        sessionService.setAuthentication(authentication);
        boolean authenticated = false;
        if (user != null) {
            authenticated = user.getPassword().equals(password);
            if (authenticated) {
                user.setLastLogged(new Date(System.currentTimeMillis()));
                userDao.updateUser(user);
                Account account = accountDao.findAccount(user.getAccount().getId());
                sessionService.setAccount(account);
            }
        }
        authentication.setAuthenticated(authenticated);
        return authentication;
    }

    public Account getAccount(long accountId) {
        return accountDao.findAccount(accountId);
    }
}
