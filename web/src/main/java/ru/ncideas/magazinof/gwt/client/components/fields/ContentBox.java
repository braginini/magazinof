package ru.ncideas.magazinof.gwt.client.components.fields;

/**
 * User: mbragin
 * Date: 01.06.12
 * Time: 10:40
 */
public interface ContentBox {

    public void setFieldLabel(String label);

    public String getFieldLabel();

    public void setValue(Object value);

    public Object getValue();

    public void setLabelPositionTop();

    public void setLabelPositionLeft();

    public void setEnabled(boolean enabled);

    public void setReadOnly(boolean readOnly);

    public void setContentBoxStyle(String styleName);
}
