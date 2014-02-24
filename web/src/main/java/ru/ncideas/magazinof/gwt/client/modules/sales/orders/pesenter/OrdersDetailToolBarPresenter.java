package ru.ncideas.magazinof.gwt.client.modules.sales.orders.pesenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.dto.OrderDto;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseToolBarViewIntf;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.OrdersEventBus;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.view.OrdersDetailToolBarView;

//created by m.bragin
@Presenter(view = OrdersDetailToolBarView.class)
public class OrdersDetailToolBarPresenter extends BasePresenter<OrdersDetailToolBarPresenter.IOrdersDetailToolBarView, OrdersEventBus> {
    public interface IOrdersDetailToolBarView extends BaseToolBarViewIntf {

    }

    public void onStart() {
        //eventBus.changeOrdersDetailToolBar(view.getViewWidget());
    }

    @Override
    public void bind() {
       view.getCancelButton().addClickHandler(new ClickHandler() {
           @Override
           public void onClick(ClickEvent clickEvent) {
               //TODO invoke changes check method (implement this method), if changes were made, show "SAVE or NOT" window
               eventBus.cancelButtonClick();
           }
       });
    }

    public void onClickOrder(OrderDto order) {
        eventBus.changeToolBarPanel(view.getViewWidget());
        //TODO логика тулбара (подсветка кнопок и тд).
    }
}
