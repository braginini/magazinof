package ru.ncideas.magazinof.gwt.client.modules.catalog;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.modules.base.abstracts.AbstractBaseModuleView;
import ru.ncideas.magazinof.gwt.util.MenuEnum;

public class CatalogView extends AbstractBaseModuleView implements CatalogPresenter.ICatalogView {

    public CatalogView() {
        addItemsMenu();
    }

    private void addItemsMenu() {
        for (MenuEnum me : getModuleMenuItems()) {
            String tabName;
            switch (me) {
                case GOODS:
                    tabName = messages.CatalogView_goods();
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