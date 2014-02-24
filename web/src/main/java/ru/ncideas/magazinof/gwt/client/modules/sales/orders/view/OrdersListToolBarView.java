package ru.ncideas.magazinof.gwt.client.modules.sales.orders.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.modules.base.abstracts.AbstractBaseToolbarView;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.pesenter.OrdersListToolBarPresenter;

public class OrdersListToolBarView extends AbstractBaseToolbarView implements OrdersListToolBarPresenter.IOrdersToolBarView{

    private static final Messages messages = GWT.create(Messages.class);
    private Button cancelOrderButton = new Button(messages.OrdersToolBarView_cancelOrderButton());
    private Button approveOrderButton = new Button(messages.OrdersToolBarView_approveOrderButton());
    private Button delayOrderButton = new Button(messages.OrdersToolBarView_delayOrderButton());


    public OrdersListToolBarView() {
        super();
        addAddButton(messages.Common_Add());
        addButton(cancelOrderButton, "mf-cancel");
        addButton(approveOrderButton, "mf-normal");
        addButton(delayOrderButton, "mf-normal");
        /*addDeleteButton(messages.Common_Delete());
        addSaveButton(messages.Common_Save());
        addCancelButton(messages.Common_Cancel());*/
    }

    public Button getCancelOrderButton() {
        return cancelOrderButton;
    }

    public Button getApproveOrderButton() {
        return approveOrderButton;
    }

    public Button getDelayOrderButton() {
        return delayOrderButton;
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }
}
