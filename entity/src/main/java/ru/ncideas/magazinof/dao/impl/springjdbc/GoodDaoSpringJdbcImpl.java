package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ncideas.magazinof.dao.GoodDao;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.GoodRowMapper;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.extended.GoodRowMapperExt;
import ru.ncideas.magazinof.entity.Good;

import java.util.List;

/**
 * User: mbragin
 * Date: 07.06.12
 * Time: 11:32
 */
@Repository
public class GoodDaoSpringJdbcImpl extends AbstractSpringJdbc implements GoodDao {

    private String goodsTableName = "goods";
    private String measuresTableName = "measures";
    private static final Logger log = LoggerFactory.getLogger(GoodDaoSpringJdbcImpl.class);

    @Override
    public List<Good> findGoodsByAccount(Long accountId) {
        try {
            List<Good> goodList = getNamedJdbcTemplate().query("SELECT * FROM " + goodsTableName +
                    " WHERE account_id = :accountId", new MapSqlParameterSource("accountId", accountId),
                    new GoodRowMapper());
            return goodList;
        } catch (EmptyResultDataAccessException e) {
            log.error(e.toString());
            return null;
        }
    }

    @Override
    public Good findGoodById(Long goodId) {
        try {
            Good good = getNamedJdbcTemplate().queryForObject("SELECT g.*, " +
                    "m.id AS measure_id, m.name AS measure_name " +
                    "FROM " + goodsTableName + " g " +
                    "LEFT JOIN " + measuresTableName + " m ON g.measure_id = m.id " +
                    "WHERE g.id = :goodId ",
                    new MapSqlParameterSource("goodId", goodId),
                    new GoodRowMapperExt());
            return good;
        } catch (EmptyResultDataAccessException e) {
            log.error(e.toString());
            return null;
        }
    }

    @Override
    public Long saveGood(Good good) {
        if (good.getId() == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            try {
                getNamedJdbcTemplate().update("INSERT INTO " + goodsTableName + " " +
                        "(name, article, description, organization_id, account_id, measure_id) " +
                        "VALUES (:name, " +
                        ":article, " +
                        ":description, " +
                        ":organization_id, " +
                        ":account_id, " +
                        ":measure_id)",
                        new MapSqlParameterSource()
                                .addValue("name", good.getName())
                                .addValue("article", good.getArticle())
                                .addValue("description", good.getDescription())
                                .addValue("organization_id", good.getOrganizationId())
                                .addValue("account_id", good.getAccountId())
                                .addValue("measure_id", good.getMeasureId()),
                        keyHolder, new String[]{"id"});
                good.setId(keyHolder.getKey().longValue());
            } catch (DataAccessException e) {
                log.error(e.toString());
                return null;
            }
        } else {
            good.setId(updateGood(good));
        }
        return good.getId();
    }

    @Override
    public Long updateGood(Good good) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            getNamedJdbcTemplate().update("UPDATE " + goodsTableName + " " +
                    "SET name = :name, " +
                    "article = :article, " +
                    "description = :description, " +
                    "organization_id = :organization_id, " +
                    "account_id = :account_id, " +
                    "measure_id = :measure_id " +
                    "WHERE id = :id",
                    new MapSqlParameterSource()
                            .addValue("name", good.getName())
                            .addValue("article", good.getArticle())
                            .addValue("description", good.getDescription())
                            .addValue("organization_id", good.getOrganizationId())
                            .addValue("account_id", good.getAccountId())
                            .addValue("measure_id", good.getMeasureId())
                            .addValue("id", good.getId()),
                    keyHolder, new String[]{"id"});
            return keyHolder.getKey().longValue();
        } catch (DataAccessException e) {
            log.error(e.toString());
            return null;
        }
    }

    @Override
    @Transactional
    public boolean deleteGoods(List<Long> idsToDelete) {
        boolean result = false;
        for (Long id : idsToDelete) {
            result = deleteGood(id);
        }
        return result;
    }

    @Override
    public boolean deleteGood(Long goodId) {
        try {
            getNamedJdbcTemplate().update("DELETE FROM " + goodsTableName + " WHERE id = :id",
                    new MapSqlParameterSource("id", goodId));
            return true;
        } catch (DataAccessException e) {
            log.error(e.toString());
            return false;
        }
    }

}
