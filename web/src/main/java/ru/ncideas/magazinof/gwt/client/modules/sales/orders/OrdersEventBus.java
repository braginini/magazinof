package ru.ncideas.magazinof.gwt.client.modules.sales.orders;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;
import ru.ncideas.magazinof.gwt.client.dto.OrderDto;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.pesenter.*;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.view.OrdersRootView;

//created by m.bragin
@Events(startView = OrdersRootView.class, module = OrdersModule.class)
public interface OrdersEventBus extends EventBus {

    //views initialization events
    @Event(forwardToParent = true)
    public void addToMainPanel(Widget widget);

    @Event(handlers = OrdersRootPresenter.class)
    void changeMainPanel(Widget widget);

    @Event(handlers = OrdersRootPresenter.class)
    void changeToolBarPanel(Widget widget);

    @Event
    public void goToOrders();

    //start module event
    @Start
    @Event(handlers = {
            OrdersRootPresenter.class,
            OrdersListPresenter.class,
            OrdersListToolBarPresenter.class,
            OrdersDetailPresenter.class,
            OrdersDetailToolBarPresenter.class})
    public void start();

    //action events
    @Event(handlers = {
            OrdersDetailToolBarPresenter.class,
            OrdersDetailPresenter.class })
    void clickOrder(OrderDto order);

    @Event(handlers = {
            OrdersListPresenter.class,
            OrdersListToolBarPresenter.class})
    void cancelButtonClick();

}
