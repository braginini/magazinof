package ru.ncideas.magazinof.gwt.client.components;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * User: mbragin
 * Date: 24.03.12
 * Time: 14:33
 */
public class AdvancedTab extends Composite implements ClickHandler{

    private Label label = new Label();
    private Label imageContainer = new Label("1");
    private VerticalPanel body = new VerticalPanel();


    public AdvancedTab(String text, String imageStyleName) {
        label.setText(text);
        body.add(imageContainer);
        body.add(label);
        this.imageContainer.setStyleName(imageStyleName);
        initWidget(body);
    }

    @Override
    public void onClick(ClickEvent event) {

    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Widget getImageContainer() {
        return imageContainer;
    }

    public void setImageContainer(Label imageContainer) {
        this.imageContainer = imageContainer;
    }
}
