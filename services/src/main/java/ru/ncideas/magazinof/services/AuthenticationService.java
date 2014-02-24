package ru.ncideas.magazinof.services;


import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.security.CustomUserAuthentication;

public interface AuthenticationService {

    public CustomUserAuthentication authenticate(String username, String password);

    public Account getAccount(long accountId);
}
