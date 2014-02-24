package ru.ncideas.magazinof.dao;

import ru.ncideas.magazinof.entity.Good;

import java.util.List;

//created by m.bragin
public interface GoodDao {

    List<Good> findGoodsByAccount(Long accountId);

    Good findGoodById(Long goodId);

    Long saveGood(Good good);

    Long updateGood(Good good);

    boolean deleteGoods(List<Long> idsToDelete);

    boolean deleteGood(Long goodId);
}
