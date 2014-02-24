package ru.ncideas.magazinof.gwt.server;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ncideas.magazinof.gwt.client.dto.OrderDto;
import ru.ncideas.magazinof.gwt.client.dto.OrganizationDto;
import ru.ncideas.magazinof.gwt.client.services.RpcOrdersModuleService;
import ru.ncideas.magazinof.gwt.util.AutoinjectingRemoteServiceServlet;
import ru.ncideas.magazinof.gwt.util.DozerGenerator;
import ru.ncideas.magazinof.services.OrderService;

import java.util.List;

//created by m.bragin
public class RpcOrdersModuleServiceImpl extends AutoinjectingRemoteServiceServlet implements RpcOrdersModuleService {

    @Autowired
    DozerBeanMapper mapper;

    @Autowired
    OrderService orderService;

    @Override
    public List<OrderDto> findOrdersByOrganization(OrganizationDto organization) throws IllegalArgumentException {
        return DozerGenerator.orderListEntityToDto(mapper, orderService.findOrdersByOrganizationExt(
                DozerGenerator.organizationDtoToEntity(mapper, organization)));
    }

    @Override
    public OrderDto findOrderById(Long id) throws IllegalArgumentException {
        return DozerGenerator.orderEntityToDto(mapper, orderService.findOrderById(id));
    }
}
