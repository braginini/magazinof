package ru.ncideas.magazinof.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import ru.ncideas.magazinof.entity.Account;

public interface AccountDao {

    public Account findAccount(long accountId) throws EmptyResultDataAccessException;
}
