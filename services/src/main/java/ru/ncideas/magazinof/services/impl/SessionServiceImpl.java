package ru.ncideas.magazinof.services.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.entity.User;
import ru.ncideas.magazinof.security.CustomUserAuthentication;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Service
public class SessionServiceImpl implements ru.ncideas.magazinof.services.SessionService {

    private Map<Serializable, Serializable> attributes = new HashMap<Serializable, Serializable>();

    private Account account;

    public CustomUserAuthentication getAuthentication() {
        return (CustomUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }

    public void setAuthentication(CustomUserAuthentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User getUser() {
        return (getAuthentication() != null) ? getAuthentication().getUser() : null;
    }

    public Account getAccount() {
        return account;
    }

    public boolean isAuthenticated() {
        return getAuthentication() != null && getAuthentication().isAuthenticated();
    }

    public void setAttribute(Serializable key, Serializable value) {
        attributes.put(key, value);
    }

    public Serializable getAttribute(Serializable key) {
        return attributes.get(key);
    }

    public void removeAttribute(Serializable key) {
        attributes.remove(key);
    }

    public boolean containsAttribute(Serializable key) {
        return attributes.containsKey(key);
    }

    public void logout() {
        setAuthentication(null);
        attributes.clear();
    }
}
