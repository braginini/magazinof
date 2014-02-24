package ru.ncideas.magazinof.gwt.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.ncideas.magazinof.gwt.client.dto.OrderDto;
import ru.ncideas.magazinof.gwt.client.dto.OrganizationDto;

import java.util.List;

//created by m.bragin
@RemoteServiceRelativePath("RpcOrdersModuleService")
public interface RpcOrdersModuleService extends RemoteService {

    public List<OrderDto> findOrdersByOrganization(OrganizationDto  organization) throws IllegalArgumentException;

    public OrderDto findOrderById(Long  id) throws IllegalArgumentException;
}
