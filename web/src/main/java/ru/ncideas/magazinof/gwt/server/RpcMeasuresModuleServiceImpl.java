package ru.ncideas.magazinof.gwt.server;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ncideas.magazinof.gwt.client.dto.MeasureDto;
import ru.ncideas.magazinof.gwt.client.services.RpcMeasuresModuleService;
import ru.ncideas.magazinof.gwt.util.AutoinjectingRemoteServiceServlet;
import ru.ncideas.magazinof.gwt.util.DozerGenerator;
import ru.ncideas.magazinof.services.MeasureService;

import java.util.List;

/**
 * User: mbragin
 * Date: 14.06.12
 * Time: 17:10
 */

public class RpcMeasuresModuleServiceImpl extends AutoinjectingRemoteServiceServlet implements RpcMeasuresModuleService {

    @Autowired
    MeasureService service;

    @Autowired
    DozerBeanMapper mapper;


    @Override
    public List<MeasureDto> findMeasuresByAccount(Long accountId) throws IllegalArgumentException {

        return DozerGenerator.measureListEntityToDto(mapper, service.findMeasuresByAccount(accountId));
    }
}
