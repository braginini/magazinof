package ru.ncideas.magazinof.gwt.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.ncideas.magazinof.gwt.client.dto.GoodDto;

import java.util.List;

/**
 * User: mbragin
 * Date: 07.06.12
 * Time: 11:24
 */
@RemoteServiceRelativePath("RpcGoodsModuleService")
public interface RpcGoodsModuleService extends RemoteService {

    List<GoodDto> findGoodsByAccount(Long accountId) throws IllegalArgumentException;

    List<GoodDto> findGoodsByOrganization(Long organizationId) throws IllegalArgumentException;

    GoodDto findGoodById(Long goodId) throws IllegalArgumentException;

    Long saveGood(GoodDto goodDto) throws IllegalArgumentException;

    boolean deleteGoods(List<Long> idsToDelete) throws IllegalArgumentException;

    boolean deleteGood(Long id) throws IllegalArgumentException;

}
