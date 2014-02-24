package ru.ncideas.magazinof.gwt.client.modules.admin.users.view;

import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.presenter.UsersRootPresenter;
import ru.ncideas.magazinof.gwt.client.modules.base.abstracts.AbstractBaseSubModuleView;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:55
 */
public class UsersRootView extends AbstractBaseSubModuleView implements UsersRootPresenter.IUsersRootView {

    //private SimplePanel firstDetailPanel = new SimplePanel();

    public UsersRootView() {
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
