package ru.ncideas.magazinof.gwt.client.modules.admin.users.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.dto.UserDto;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.UsersEventBus;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.view.UsersDetailToolBarView;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseToolBarViewIntf;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:56
 */
@Presenter(view = UsersDetailToolBarView.class)
public class UsersDetailToolBarPresenter extends BasePresenter<UsersDetailToolBarPresenter.IUsersDetailToolBarView, UsersEventBus> {
    public interface IUsersDetailToolBarView extends BaseToolBarViewIntf {
        Button getSaveButton();

        Button getCancelButton();
    }

    public void onStart() {
        //eventBus.changeOrdersDetailToolBar(view.getViewWidget());
    }

    @Override
    public void bind() {
        view.getSaveButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                //TODO invoke changes check method (implement this method), if changes were made, show "SAVE or NOT" window
                eventBus.cancelButtonClick();
            }
        });

        view.getCancelButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                //TODO invoke changes check method (implement this method), if changes were made, show "SAVE or NOT" window
                eventBus.cancelButtonClick();
            }
        });
    }

    public void onClickUser(UserDto user) {
        eventBus.changeToolBarPanel(view.getViewWidget());
        //TODO логика тулбара (подсветка кнопок и тд).
    }

    public void onAddButtonClick() {
        eventBus.changeToolBarPanel(view.getViewWidget());
    }
}
