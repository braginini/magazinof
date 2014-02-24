package ru.ncideas.magazinof.gwt.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.ncideas.magazinof.gwt.client.dto.MeasureDto;

import java.util.List;

/**
 * User: mbragin
 * Date: 14.06.12
 * Time: 17:09
 */
@RemoteServiceRelativePath("RpcMeasuresModuleService")
public interface RpcMeasuresModuleService extends RemoteService {

    List<MeasureDto> findMeasuresByAccount(Long accountId) throws IllegalArgumentException;
}
