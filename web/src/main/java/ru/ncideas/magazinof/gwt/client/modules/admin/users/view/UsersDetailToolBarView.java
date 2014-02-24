package ru.ncideas.magazinof.gwt.client.modules.admin.users.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.presenter.UsersDetailToolBarPresenter;
import ru.ncideas.magazinof.gwt.client.modules.base.abstracts.AbstractBaseToolbarView;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:55
 */
public class UsersDetailToolBarView extends AbstractBaseToolbarView implements UsersDetailToolBarPresenter.IUsersDetailToolBarView {

    private static final Messages messages = GWT.create(Messages.class);

    public UsersDetailToolBarView() {
        addSaveButton(messages.Common_Save());
        addCancelButton(messages.Common_Cancel());
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }
}
