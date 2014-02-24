package ru.ncideas.magazinof.gwt.client.modules.sales;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.annotation.module.ChildModule;
import com.mvp4g.client.annotation.module.ChildModules;
import com.mvp4g.client.annotation.module.DisplayChildModuleView;
import com.mvp4g.client.event.EventBus;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.OrdersModule;

//created by m.bragin
@Events(startView = SalesView.class, module = SalesModule.class)
@ChildModules({
        @ChildModule(moduleClass = OrdersModule.class)})
public interface SalesEventBus extends EventBus {

    @Event
    public void goToSales();

    @Event(forwardToParent = true)
    public void changeCenterPanel(Widget widget);

    @DisplayChildModuleView(value = {OrdersModule.class})
    @Event(handlers = SalesPresenter.class)
    public void addToMainPanel(Widget widget);

    @Event(modulesToLoad = OrdersModule.class)
    void goToOrders();

    @Start
    @Event(handlers = SalesPresenter.class)
    public void start();

}
