package ru.ncideas.magazinof.gwt.client.modules.catalog.goods.presenter;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.components.LinkCell;
import ru.ncideas.magazinof.gwt.client.dto.AccountDto;
import ru.ncideas.magazinof.gwt.client.dto.GoodDto;
import ru.ncideas.magazinof.gwt.client.dto.MeasureDto;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseListViewIntf;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.GoodsEventBus;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.view.GoodsListView;
import ru.ncideas.magazinof.gwt.client.registry.Registry;
import ru.ncideas.magazinof.gwt.client.services.RpcGoodsModuleServiceAsync;
import ru.ncideas.magazinof.gwt.client.services.RpcMeasuresModuleServiceAsync;
import ru.ncideas.magazinof.gwt.client.services.RpcSessionServiceAsync;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: mbragin
 * Date: 20.04.12
 * Time: 11:56
 */
@Presenter(view = GoodsListView.class)
public class GoodsListPresenter extends BasePresenter<GoodsListPresenter.IGoodsListView, GoodsEventBus> {

    public interface IGoodsListView extends BaseListViewIntf<GoodDto> {

    }

    @Inject
    RpcGoodsModuleServiceAsync service;

    @Inject
    RpcMeasuresModuleServiceAsync measuresService;

    @Inject
    RpcSessionServiceAsync sessionService;

    @Override
    public void bind() {
        view.getTable().addCellPreviewHandler(new CellPreviewEvent.Handler<GoodDto>() {
            @Override
            public void onCellPreview(CellPreviewEvent<GoodDto> event) {
                boolean isClickEvent = "click".equals(event.getNativeEvent().getType());
                Cell clickedCell = view.getTable().getColumn(event.getColumn()).getCell();
                if (isClickEvent) {
                    if (isLinkCell(clickedCell)) {
                        eventBus.clickGood(event.getValue());
                    }
                }

            }
        });

        final MultiSelectionModel<GoodDto> selectionModel = (MultiSelectionModel<GoodDto>) view.getSelectionModel();
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent selectionChangeEvent) {
                boolean somethingIsSelected = (!selectionModel.getSelectedSet().isEmpty()) ? true : false;
                eventBus.listItemsSelected(somethingIsSelected);
            }
        });
        view.getTable().setSelectionModel(selectionModel, DefaultSelectionEventManager.<GoodDto>createCheckboxManager());
    }

    private boolean isLinkCell(Cell clickedCell) {
        return (clickedCell.getClass().equals(LinkCell.class)) ? true : false;
    }

    public void onStart() {
        loadGoodsList();
        eventBus.changeMainPanel(view.getViewWidget());
    }

    private void loadGoodsList() {
        sessionService.getAccount(new AsyncCallback<AccountDto>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(AccountDto result) {
                eventBus.accountReceived(result);
            }
        });
    }

    public void onCancelButtonClick() {
        eventBus.changeMainPanel(view.getViewWidget());
    }

    public void onAccountReceived(AccountDto accountDto) {

        measuresService.findMeasuresByAccount(accountDto.getId(), new AsyncCallback<List<MeasureDto>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //TODO implement method

            }

            @Override
            public void onSuccess(List<MeasureDto> measureDtos) {
                Registry.register("measures", measureDtos);
            }
        });

        service.findGoodsByAccount(accountDto.getId(), new AsyncCallback<List<GoodDto>>() {

            @Override
            public void onFailure(Throwable caught) {
                GWT.log("RPC ERROR : " + this.getClass().getName() + " service findGoodsByAccount error", caught);
            }

            @Override
            public void onSuccess(List<GoodDto> result) {
                GWT.log("RPC SUCCESS : " + this.getClass().getName() + "findGoodsByAccount GoodsList successfully loaded");
                view.loadList(result);
            }
        });
    }

    public void onNewGoodAdded(GoodDto newGood) {
        view.addValueToList(newGood);
    }

    public void onGoodUpdated(GoodDto newGood) {
        //TODO maybe not update list manually, but make an rpc to Db (loadGoodsList)
        view.updateList(newGood);
    }

    public void onDeleteButtonClick() {
        Set<GoodDto> selectedGoods = ((MultiSelectionModel) view.getTable().getSelectionModel()).getSelectedSet();
        beforeDeleteActions(selectedGoods);
    }

    private void beforeDeleteActions(final Set<GoodDto> selectedGoods) {
        List<Long> idsToDelete = new ArrayList<Long>();
        for (GoodDto g : selectedGoods) {
            idsToDelete.add(g.getId());
        }
        if (!idsToDelete.isEmpty()) {
            //TODO check if this ids are foreign keys (e.g. in orders)
            service.deleteGoods(idsToDelete, new AsyncCallback<Boolean>() {
                @Override
                public void onFailure(Throwable throwable) {

                }

                @Override
                public void onSuccess(Boolean result) {
                    afterDeleteActions(result, selectedGoods);
                }
            });
        }
    }

    private void afterDeleteActions(Boolean result, Set<GoodDto> deletedGoods) {
        if (result) {
            eventBus.goodsDeleted(deletedGoods);
        }
    }

    public void onGoodsDeleted(Set<GoodDto> deletedGoods) {
        for (GoodDto goodDto : deletedGoods) {
            view.removeValueFromList(goodDto);
        }
    }

}
