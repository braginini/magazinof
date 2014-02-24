package ru.ncideas.magazinof.gwt.client.modules.admin.settings.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.modules.admin.settings.presenter.SettingsPresenter;


public class SettingsView extends Composite implements SettingsPresenter.ISettingsView {

    private static final Messages messages = GWT.create(Messages.class);

    private FlexTable body = new FlexTable();

    private TextBox option1 = new TextBox();
    private TextBox option2 = new TextBox();
    private TextBox option3 = new TextBox();

    private Button saveBtn = new Button(messages.Common_Save());
    private Button cancelBt = new Button(messages.Common_Cancel());

    public SettingsView() {
        initComponents();
        initWidget(body);
    }

    private FlexTable initComponents() {
        body.setWidget(0, 0, new Label("Test Option 1"));
        body.setWidget(1, 0, new Label("Test Option 2"));
        body.setWidget(2, 0, new Label("Test Option 3"));

        option1.setStyleName("mf-textbox");
        option2.setStyleName("mf-textbox");
        option3.setStyleName("mf-textbox");

        body.setWidget(0, 1, option1);
        body.setWidget(1, 1, option2);
        body.setWidget(2, 1, option3);

        saveBtn.setStyleName("mf-add");
        cancelBt.setStyleName("mf-cancel");

        body.setWidget(3, 0, saveBtn);
        body.setWidget(3, 1, cancelBt);
        return body;
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }
}
