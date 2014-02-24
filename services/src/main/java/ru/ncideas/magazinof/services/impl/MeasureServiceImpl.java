package ru.ncideas.magazinof.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.MeasureDao;
import ru.ncideas.magazinof.entity.Measure;
import ru.ncideas.magazinof.services.MeasureService;

import java.util.List;

/**
 * User: mbragin
 * Date: 14.06.12
 * Time: 17:18
 */
@Service
public class MeasureServiceImpl implements MeasureService {

    @Autowired
    MeasureDao measureDao;

    @Override
    public List<Measure> findMeasuresByAccount(Long accountId) {
        return measureDao.findMeasuresByAccount(accountId);
    }
}
