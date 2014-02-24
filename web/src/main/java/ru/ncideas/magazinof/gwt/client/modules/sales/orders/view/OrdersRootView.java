package ru.ncideas.magazinof.gwt.client.modules.sales.orders.view;

import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.modules.base.abstracts.AbstractBaseSubModuleView;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.pesenter.OrdersRootPresenter;

//created by m.bragin
public class OrdersRootView extends AbstractBaseSubModuleView implements OrdersRootPresenter.IOrdersRootView {

    //private SimplePanel firstDetailPanel = new SimplePanel();

    public OrdersRootView() {
        //now we need only one detail panel
        //may be we will have the need to add more panels (map panel, more details etc.)
        //to archive it we only need to use  addPanelToDetailPanel(widget, size) for each panel
        // to add panels one by one. See UserRootView class for example
        //addFirstDetailPanel();
    }

    /*private void addFirstDetailPanel() {
        addPanelToDetailPanel(firstDetailPanel);
    }

    public SimplePanel getFirstDetailPanel() {
        return firstDetailPanel;
    }*/

    @Override
    public Widget getViewWidget() {
        return this;
    }
}
