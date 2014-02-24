package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.UserStatusDao;

@Service
public class UserStatusDaoSpringJdbcImpl extends AbstractSpringJdbc implements UserStatusDao {

    private String tableName = "user_statuses";

}
