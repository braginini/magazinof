package ru.ncideas.magazinof.gwt.client.modules.sales.orders.pesenter;

import com.google.gwt.user.client.ui.Button;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseToolBarViewIntf;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.OrdersEventBus;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.view.OrdersListToolBarView;


//created by m.bragin
@Presenter(view = OrdersListToolBarView.class)
public class OrdersListToolBarPresenter extends BasePresenter<OrdersListToolBarPresenter.IOrdersToolBarView, OrdersEventBus> {

    public interface IOrdersToolBarView extends BaseToolBarViewIntf {

        Button getApproveOrderButton();
        Button getCancelOrderButton();
        Button getDelayOrderButton();
    }

    public void onStart() {
        view.getApproveOrderButton().setEnabled(false);
        view.getCancelOrderButton().setEnabled(false);
        view.getDelayOrderButton().setEnabled(false);
        eventBus.changeToolBarPanel(view.getViewWidget());
    }

    public void onCancelButtonClick() {
        eventBus.changeToolBarPanel(view.getViewWidget());
    }
}
