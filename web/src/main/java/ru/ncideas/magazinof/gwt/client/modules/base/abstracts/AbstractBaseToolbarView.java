package ru.ncideas.magazinof.gwt.client.modules.base.abstracts;

import com.google.gwt.user.client.ui.*;

public abstract class AbstractBaseToolbarView extends Composite {

    protected FlowPanel body = new FlowPanel();

    protected Button addButton = new Button();
    protected Button deleteButton = new Button();
    protected Button saveButton = new Button();
    protected Button cancelButton = new Button();

    public AbstractBaseToolbarView() {
        body.setStyleName("toolBar");
        initWidget(body);
    }

    public void addAddButton(String label) {
        addButton.setStyleName("mf-add");
        addButton.setText(label);

        body.add(addButton);
    }

    public void addDeleteButton(String label) {
        deleteButton.setText(label);
        deleteButton.setStyleName("mf-cancel");
        body.add(deleteButton);
    }

    public void addSaveButton(String label) {
        saveButton.setText(label);
        saveButton.setStyleName("mf-add");
        body.add(saveButton);
    }

    public void addCancelButton(String label) {
        cancelButton.setText(label);
        cancelButton.setStyleName("mf-cancel");
        body.add(cancelButton);
    }

    public void addButton(Button button, String styleName) {
        button.setStyleName(styleName);
        body.add(button);
    }

    public FlowPanel getBody() {
        return body;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }
}
