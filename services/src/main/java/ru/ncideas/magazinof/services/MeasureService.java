package ru.ncideas.magazinof.services;

import ru.ncideas.magazinof.entity.Measure;

import java.util.List;

/**
 * User: mbragin
 * Date: 14.06.12
 * Time: 17:16
 */
public interface MeasureService {

    List<Measure> findMeasuresByAccount(Long accountId);
}
