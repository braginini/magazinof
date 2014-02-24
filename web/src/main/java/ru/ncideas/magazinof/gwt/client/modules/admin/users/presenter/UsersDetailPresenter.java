package ru.ncideas.magazinof.gwt.client.modules.admin.users.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Label;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomListBox;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomTextBox;
import ru.ncideas.magazinof.gwt.client.dto.UserDto;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.UsersEventBus;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.view.UsersDetailView;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseViewIntf;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:56
 */
@Presenter(view = UsersDetailView.class)
public class UsersDetailPresenter extends BasePresenter<UsersDetailPresenter.IUsersDetailView, UsersEventBus> {

    public interface IUsersDetailView extends BaseViewIntf {
        Label getUserId();

        CustomTextBox getUsername();

        CustomTextBox getFirstName();

        CustomTextBox getLastName();

        CustomTextBox getEmail();

        CustomListBox getStatus();

        Label getCreated();

        Label getLastLogged();
    }

    private UserDto userDto;

    public void onStart() {
    }

    public void onClickUser(UserDto userDto) {
        eventBus.changeMainPanel(view.getViewWidget());
        view.getUsername().setReadOnly(true);
        fillForm(userDto);
    }

    public void onAddButtonClick() {
        eventBus.changeMainPanel(view.getViewWidget());
        fillForm(new UserDto());
    }

    private void fillForm(UserDto userDto) {
        this.userDto = userDto;
        try {
            view.getUserId().setText(userDto.getId() != null ? userDto.getId().toString() : "---");
            view.getUsername().setValue(userDto.getUsername());
            view.getFirstName().setValue(userDto.getFirst_name());
            view.getLastName().setValue(userDto.getLast_name());
            view.getEmail().setValue(userDto.getEmail());
            //TODO: create status DropBox
            view.getCreated().setText(userDto.getCreated() != null
                    ? DateTimeFormat.getFormat("dd.MM.yyyy HH:mm").format((userDto.getCreated())) : "---");
            view.getLastLogged().setText(userDto.getLastLogged() != null
                    ? DateTimeFormat.getFormat("dd.MM.yyyy HH:mm").format((userDto.getLastLogged())) : "---");
        } catch (NullPointerException e) {
            GWT.log("Error while filling details form", e);
        }
    }
}
