package ru.ncideas.magazinof.gwt.client.components.fields.impl;

import com.google.gwt.user.client.ui.ListBox;
import ru.ncideas.magazinof.gwt.client.components.fields.AbstractContentBox;

/**
 * User: mbragin
 * Date: 11.04.12
 * Time: 17:45
 */
public class CustomListBox extends AbstractContentBox{

    private ListBox contentBox = new ListBox();

    public CustomListBox() {
        addBox(contentBox);
    }

    @Override
    public void setValue(Object value) {
       contentBox.setValue(0, value.toString());
    }

    @Override
    public Object getValue() {
        //TODO implement method
        return null;
    }

    @Override
    public void setEnabled(boolean enabled) {
        //TODO implement method

    }

    @Override
    public void setReadOnly(boolean readOnly) {
        //TODO implement method

    }

    @Override
    public void setContentBoxStyle(String styleName) {
        contentBox.setStyleName(styleName);

    }

    public void addItem(String value) {
        contentBox.addItem(value);
    }

    public void clearList() {
        contentBox.clear();
    }
}
