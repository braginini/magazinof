package ru.ncideas.magazinof.gwt.client.modules.sales.orders.pesenter;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.CellPreviewEvent;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.components.LinkCellSharp;
import ru.ncideas.magazinof.gwt.client.dto.OrderDto;
import ru.ncideas.magazinof.gwt.client.dto.OrganizationDto;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseListViewIntf;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.OrdersEventBus;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.view.OrdersListView;
import ru.ncideas.magazinof.gwt.client.services.RpcOrdersModuleServiceAsync;

import javax.inject.Inject;
import java.util.List;

//created by m.bragin
@Presenter(view = OrdersListView.class)
public class OrdersListPresenter extends BasePresenter<OrdersListPresenter.IOrdersListView, OrdersEventBus> {
    public interface IOrdersListView extends BaseListViewIntf<OrderDto> {

    }

    @Inject
    RpcOrdersModuleServiceAsync service;

    @Override
    public void bind() {
        view.getTable().addCellPreviewHandler(new CellPreviewEvent.Handler<OrderDto>() {
            @Override
            public void onCellPreview(CellPreviewEvent<OrderDto> event) {
                boolean isClickEvent = "click".equals(event.getNativeEvent().getType());
                Cell clickedCell = view.getTable().getColumn(event.getColumn()).getCell();
                if (isClickEvent && isLinkCell(clickedCell)) {
                    eventBus.clickOrder(event.getValue());
                }

            }
        });
    }

    private boolean isLinkCell(Cell clickedCell) {
        return (clickedCell.getClass().equals(LinkCellSharp.class)) ? true : false;
    }

    public void onStart() {
        loadOrderList();
        eventBus.changeMainPanel(view.getViewWidget());
    }

    private void loadOrderList() {
        //TODO remove zaglushky
        //testHttpRequestWithJSON();
        OrganizationDto org = new OrganizationDto();
        org.setId(1l);
        service.findOrdersByOrganization(org, new AsyncCallback<List<OrderDto>>() {
            @Override
            public void onFailure(Throwable throwable) {
                GWT.log("RPC ERROR : " + this.getClass().getName() + " service findOrdersByOrganization error", throwable);
            }

            @Override
            public void onSuccess(List<OrderDto> orderList) {
                GWT.log("RPC SUCCESS : " + this.getClass().getName() + "findOrdersByOrganization OrderList successfully loaded");
                view.loadList(orderList);
            }
        });

    }
    //TODO method just for testing spring mvc + gwt
    private void testHttpRequestWithJSON() {
        String url = "http://127.0.0.1:8888/rest/user/1/";
        System.out.println(url);
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
        try {
            Request request = builder.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    if (200 == response.getStatusCode()) {
                        System.out.println(response.getText());
                    } else {
                        System.out.println(response.getStatusCode());
                    }
                }

                @Override
                public void onError(Request request, Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        } catch (RequestException e) {
            e.printStackTrace();
        }

    }

    public void onChangeOrdersListToolBar(Widget widget) {
        view.addToolBar(widget);
    }

    public void onCancelButtonClick() {
        eventBus.changeMainPanel(view.getViewWidget());
    }
}
