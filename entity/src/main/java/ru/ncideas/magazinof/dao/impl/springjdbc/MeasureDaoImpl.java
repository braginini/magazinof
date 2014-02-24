package ru.ncideas.magazinof.dao.impl.springjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.MeasureDao;
import ru.ncideas.magazinof.dao.impl.springjdbc.mapper.MeasureRowMapper;
import ru.ncideas.magazinof.entity.Measure;

import java.util.List;

/**
 * User: mbragin
 * Date: 14.06.12
 * Time: 17:19
 */
@Service
public class MeasureDaoImpl extends AbstractSpringJdbc implements MeasureDao {

    private final String measuresTable = "measures";
    private static final Logger log = LoggerFactory.getLogger(GoodDaoSpringJdbcImpl.class);

    @Override
    public List<Measure> findMeasuresByAccount(Long accountId) {
        try {
            List<Measure> measureList = getNamedJdbcTemplate().query("SELECT * FROM " + measuresTable +
                    " WHERE account_id = :accountId", new MapSqlParameterSource("accountId", accountId),
                    new MeasureRowMapper());
            return measureList;
        } catch (EmptyResultDataAccessException e) {
            log.error(e.toString());
            return null;
        }
    }
}
