package ru.ncideas.magazinof.gwt.client.modules.admin;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.modules.base.abstracts.AbstractBaseModuleView;
import ru.ncideas.magazinof.gwt.util.MenuEnum;

public class AdminView extends AbstractBaseModuleView implements AdminPresenter.IAdminView {

    public AdminView() {
        addItemsMenu();
    }

    private void addItemsMenu() {
        for (MenuEnum me : getModuleMenuItems()) {
            String tabName;
            switch (me) {
                case USERS:
                    tabName = messages.AdminView_users();
                    break;
                case SETTINGS:
                    tabName = messages.AdminView_settings();
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