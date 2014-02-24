package ru.ncideas.magazinof.services;

import ru.ncideas.magazinof.entity.Good;

import java.util.List;

//created by m.bragin
public interface GoodService {

    List<Good> findGoodsByAccount(Long accountId);

    Good findGoodById(Long goodId);

    Long saveGood(Good good);

    boolean deleteGoods(List<Long> idsToDelete);
}
