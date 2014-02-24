package ru.ncideas.magazinof.services;

import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.entity.User;
import ru.ncideas.magazinof.security.CustomUserAuthentication;

import java.io.Serializable;

public interface SessionService {

    public CustomUserAuthentication getAuthentication();

    public void setAuthentication(CustomUserAuthentication authentication);

    public void setAccount(Account account);

    public User getUser();

    public Account getAccount();

    public boolean isAuthenticated();

    public void setAttribute(Serializable key, Serializable value);

    public Serializable getAttribute(Serializable key);

    public void removeAttribute(Serializable key);

    public boolean containsAttribute(Serializable key);

    public void logout();
}
