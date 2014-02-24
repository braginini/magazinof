package ru.ncideas.magazinof.gwt.client.components.fields;

import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.components.forms.ContentPanel;
import ru.ncideas.magazinof.gwt.client.components.forms.Orientation;

import java.util.ArrayList;
import java.util.List;

/**
 * User: mbragin
 * Date: 01.06.12
 * Time: 12:35
 */
public class AbstractContentBox extends ContentPanel {

    protected ContentPanel labelAndBox = new ContentPanel(); //inits label and contentBox widgets
    protected Label label = new Label();
    private List<Button> buttonList = new ArrayList<Button>();
    private Long idValue;


    public AbstractContentBox() {
        this.setOrientation(Orientation.HORIZONTAL);
        labelAndBox.removeStyleName("mf-content-panel");
        //body.setStyleName("mf-contentbox-body");
        label.setStyleName("mf-contentbox-label");
        addLabel(label);
        this.add(labelAndBox);
    }


    public void setFieldLabel(String label) {
        this.label.setText(label);
    }


    public String getFieldLabel() {
        return label.getText();
    }


    public void setValue(Object value) {

    }


    public Object getValue() {
        return null;
    }


    public void setLabelPositionTop() {
        labelAndBox.setOrientation(Orientation.VERTICAL);
    }

    public void setLabelPositionLeft() {
        labelAndBox.setOrientation(Orientation.HORIZONTAL);
    }


    public void setEnabled(boolean enabled) {

    }


    public void setReadOnly(boolean readOnly) {

    }


    public void setContentBoxStyle(String styleName) {

    }

    /*public void addAddButton() {
        this.body.add(addButton);
    }

    public void addChooseButton() {
        this.body.add(chooseButton);
    }*/

    public void addButton(Button button) {
        this.add(button);
        this.buttonList.add(button);
    }

    public Button getButton(int index) {
        return this.buttonList.get(index);
    }

    protected void addBox(Widget w) {
        labelAndBox.add(w);
    }

    private void addLabel(Widget w) {
        labelAndBox.add(w);
    }

    public Long getIdValue() {
        return idValue;
    }

    public void setIdValue(Long id) {
        idValue = id;
    }

    public void addChangeHandler(ChangeHandler handler) {

    }
}
