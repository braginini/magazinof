package ru.ncideas.magazinof.gwt.client.components.fields.impl;

import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.TextBox;
import ru.ncideas.magazinof.gwt.client.components.fields.AbstractContentBox;
import ru.ncideas.magazinof.gwt.client.components.fields.NotAvailableFieldValueException;

/**
 * User: mbragin
 * Date: 11.04.12
 * Time: 17:43
 */

public class CustomTextBox extends AbstractContentBox {

    private TextBox contentBox = new TextBox();

    public CustomTextBox() {
        addBox(contentBox);
    }

    @Override
    public void setValue(Object value) {
        String stringValue = "";
        if (value != null) {
            if (!value.getClass().equals(String.class)) {
                throw new NotAvailableFieldValueException("Invalid field value type " + value.getClass());
            }
            stringValue = value.toString();
        }
        this.contentBox.setValue(stringValue);
    }

    @Override
    public Object getValue() {
        return this.contentBox.getValue();
    }

    @Override
    public void setEnabled(boolean enabled) {
        contentBox.setEnabled(enabled);
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        contentBox.setReadOnly(readOnly);

    }

    @Override
    public void setContentBoxStyle(String styleName) {
        contentBox.setStyleName(styleName);

    }

    @Override
    public void addChangeHandler(ChangeHandler handler) {
        contentBox.addChangeHandler(handler);
    }
}
