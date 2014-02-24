package ru.ncideas.magazinof.gwt.client.modules.sales;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.modules.base.abstracts.AbstractBaseModuleView;
import ru.ncideas.magazinof.gwt.util.MenuEnum;

//created by m.bragin
public class SalesView extends AbstractBaseModuleView implements SalesPresenter.ISalesView {

    public SalesView() {
       addItemsMenu();
    }

    private void addItemsMenu() {
        for (MenuEnum me : getModuleMenuItems()) {
            String tabName;
            switch (me) {
                case ORDERS:
                    tabName = messages.SalesView_orders();
                    break;
                case INVOICES_TO_CUSTOMERS:
                    tabName = messages.SalesView_invoicesToCustomers();
                    break;
                case SALES_RETURNS:
                    tabName = messages.SalesView_salesReturns();
                    break;
                default:
                    tabName = me.getMenuItem().getName();
            }
            Label label = new Label(tabName);
            links.put(me, label);
            menuPanel.add(label);
        }
        setMenuItemsStyles();
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }
}
