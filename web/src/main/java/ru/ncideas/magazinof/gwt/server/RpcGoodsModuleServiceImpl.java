package ru.ncideas.magazinof.gwt.server;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ncideas.magazinof.gwt.client.dto.GoodDto;
import ru.ncideas.magazinof.gwt.client.services.RpcGoodsModuleService;
import ru.ncideas.magazinof.gwt.util.AutoinjectingRemoteServiceServlet;
import ru.ncideas.magazinof.gwt.util.DozerGenerator;
import ru.ncideas.magazinof.services.GoodService;

import java.util.List;

/**
 * User: mbragin
 * Date: 07.06.12
 * Time: 11:32
 */
public class RpcGoodsModuleServiceImpl extends AutoinjectingRemoteServiceServlet implements RpcGoodsModuleService {

    @Autowired
    DozerBeanMapper mapper;

    @Autowired
    GoodService goodsService;

    @Override
    public List<GoodDto> findGoodsByAccount(Long accountId) throws IllegalArgumentException {
        return DozerGenerator.goodListEntityToDto(mapper, goodsService.findGoodsByAccount(accountId));
    }

    @Override
    public List<GoodDto> findGoodsByOrganization(Long organizationId) throws IllegalArgumentException {
        //TODO implement method
        return null;
    }

    @Override
    public GoodDto findGoodById(Long goodId) throws IllegalArgumentException {
        return DozerGenerator.goodEntityToDto(mapper, goodsService.findGoodById(goodId));
    }

    @Override
    public Long saveGood(GoodDto goodDto) throws IllegalArgumentException {
        return goodsService.saveGood(DozerGenerator.goodDtoToEntity(mapper, goodDto));
    }

    @Override
    public boolean deleteGoods(List<Long> idsToDelete) throws IllegalArgumentException {
        return goodsService.deleteGoods(idsToDelete);
    }

    @Override
    public boolean deleteGood(Long id) throws IllegalArgumentException {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
