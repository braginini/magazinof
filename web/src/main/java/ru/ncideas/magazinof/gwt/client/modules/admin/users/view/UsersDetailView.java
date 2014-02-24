package ru.ncideas.magazinof.gwt.client.modules.admin.users.view;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomListBox;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomTextBox;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.presenter.UsersDetailPresenter;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:55
 */
public class UsersDetailView extends Composite implements UsersDetailPresenter.IUsersDetailView {

    private static final Messages messages = GWT.create(Messages.class);

    private FlexTable body = new FlexTable();

    private Label userId = new Label();
    private CustomTextBox username = new CustomTextBox();
    private CustomTextBox firstName = new CustomTextBox();
    private CustomTextBox lastName = new CustomTextBox();
    private CustomTextBox email = new CustomTextBox();
    private CustomListBox status = new CustomListBox();
    private Label created = new Label();
    private Label lastLogged = new Label();

    public UsersDetailView() {
        initCommonFields();
        initWidget(body);
    }

    private void initCommonFields() {
        body.setText(1, 0, messages.UsersDetailView_userId());
        body.setWidget(1, 1, userId);

        username.setStyleName("mf-textbox");
        body.setText(2, 0, messages.UsersDetailView_username());
        body.setWidget(2, 1, username);

        firstName.setStyleName("mf-textbox");
        body.setText(3, 0, messages.UsersDetailView_firstName());
        body.setWidget(3, 1, firstName);

        lastName.setStyleName("mf-textbox");
        body.setText(4, 0, messages.UsersDetailView_lastName());
        body.setWidget(4, 1, lastName);

        email.setStyleName("mf-textbox");
        body.setText(5, 0, messages.UsersDetailView_email());
        body.setWidget(5, 1, email);

        body.setText(6, 0, messages.UsersDetailView_status());
        body.setWidget(6, 1, status);

        body.setText(7, 0, messages.UsersDetailView_created());
        body.setWidget(7, 1, created);

        body.setText(7, 2, messages.UsersDetailView_lastLogged());
        body.setWidget(7, 3, lastLogged);
    }

    public Label getUserId() {
        return userId;
    }

    public CustomTextBox getUsername() {
        return username;
    }

    public CustomTextBox getFirstName() {
        return firstName;
    }

    public CustomTextBox getLastName() {
        return lastName;
    }

    public CustomTextBox getEmail() {
        return email;
    }

    public CustomListBox getStatus() {
        return status;
    }

    public Label getCreated() {
        return created;
    }

    public Label getLastLogged() {
        return lastLogged;
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }
}
