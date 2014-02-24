package ru.ncideas.magazinof.gwt.client.modules.admin.users.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.UsersEventBus;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.view.UsersListToolBarView;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseToolBarViewIntf;


/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:56
 */
@Presenter(view = UsersListToolBarView.class)
public class UsersListToolBarPresenter extends BasePresenter<UsersListToolBarPresenter.IUsersToolBarView, UsersEventBus> {

    public interface IUsersToolBarView extends BaseToolBarViewIntf {
    }

    public void onStart() {
        view.getDeleteButton().setEnabled(false);
        view.getAddButton().setEnabled(true);
        eventBus.changeToolBarPanel(view.getViewWidget());
    }

    @Override
    public void bind() {
        view.getAddButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                eventBus.addButtonClick();
            }
        });

        view.getDeleteButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
            }
        });
    }

    public void onSaveButtonClick() {
        eventBus.changeToolBarPanel(view.getViewWidget());
    }

    public void onCancelButtonClick() {
        eventBus.changeToolBarPanel(view.getViewWidget());
    }
}
