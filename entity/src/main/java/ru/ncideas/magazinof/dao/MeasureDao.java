package ru.ncideas.magazinof.dao;

import ru.ncideas.magazinof.entity.Measure;

import java.util.List;

/**
 * User: mbragin
 * Date: 14.06.12
 * Time: 17:19
 */
public interface MeasureDao {
    List<Measure> findMeasuresByAccount(Long accountId);
}
