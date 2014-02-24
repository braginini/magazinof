package ru.ncideas.magazinof.gwt.client.modules.sales.orders.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.modules.base.abstracts.AbstractBaseToolbarView;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.pesenter.OrdersDetailToolBarPresenter;

//created by m.bragin
public class OrdersDetailToolBarView extends AbstractBaseToolbarView implements OrdersDetailToolBarPresenter.IOrdersDetailToolBarView {

    private static final Messages messages = GWT.create(Messages.class);

    public OrdersDetailToolBarView() {
        addSaveButton(messages.Common_Save());
        addCancelButton(messages.Common_Cancel());
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }
}
