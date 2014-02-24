package ru.ncideas.magazinof.gwt.client.components.fields.impl;

import com.google.gwt.user.datepicker.client.DateBox;
import ru.ncideas.magazinof.gwt.client.components.fields.AbstractContentBox;

/**
 * User: mbragin
 * Date: 11.04.12
 * Time: 17:46
 */
public class CustomDateBox extends AbstractContentBox {

    private DateBox contentBox = new DateBox();

    public CustomDateBox() {
        addBox(contentBox);
    }

    @Override
    public void setValue(Object value) {
        //TODO implement method

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
}
