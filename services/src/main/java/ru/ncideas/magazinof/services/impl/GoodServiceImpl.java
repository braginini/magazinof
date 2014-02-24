package ru.ncideas.magazinof.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ncideas.magazinof.dao.GoodDao;
import ru.ncideas.magazinof.entity.Good;
import ru.ncideas.magazinof.services.GoodService;

import java.util.List;

//created by m.bragin
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    GoodDao goodsDao;

    @Override
    public List<Good> findGoodsByAccount(Long accountId) {
        return goodsDao.findGoodsByAccount(accountId);
    }

    @Override
    public Good findGoodById(Long goodId) {
        return goodsDao.findGoodById(goodId);
    }

    @Override
    public Long saveGood(Good good) {
        return goodsDao.saveGood(good);
    }

    @Override
    public boolean deleteGoods(List<Long> idsToDelete) {
        return goodsDao.deleteGoods(idsToDelete);
    }
}
