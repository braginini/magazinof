package ru.ncideas.magazinof.dao;

import org.springframework.orm.jpa.support.JpaDaoSupport;

public class BaseDao extends JpaDaoSupport {

    protected void remove(Object object) {
        getJpaTemplate().remove(getJpaTemplate().merge(object));
    }
}
