package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.PersonDao;

@Service
public class PersonDaoSpringJdbcImpl extends AbstractSpringJdbc implements PersonDao {

    private String tableName = "persons";

}
