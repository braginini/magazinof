package ru.ncideas.magazinof.gwt.client.components.forms;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import java.util.Iterator;

/**
 * User: mbragin
 * Date: 04.06.12
 * Time: 16:14
 * Used to create custom forms with vertical or horizontal orientation
 */
public class ContentPanel extends FlowPanel {

    private Orientation orientation = Orientation.VERTICAL;      //default orientation vertical


    public ContentPanel() {
        this.setStyleName("mf-content-panel");
    }

    public ContentPanel(Orientation orientation) {
        this.setStyleName("mf-content-panel");
        setOrientation(orientation);
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;

        Iterator<Widget> it = this.iterator();
        while (it.hasNext()) {
            positionWidget(it.next());
        }
    }

    private void positionWidget(Widget w) {
        switch (this.orientation) {
            case HORIZONTAL:
                w.getElement().getStyle().setProperty("display", "inline-block");
                break;
            case VERTICAL:
                w.getElement().getStyle().clearDisplay();
                break;
            default:
                break;
        }

    }

    @Override
    public void add(Widget w) {
        positionWidget(w);
        super.add(w);
    }

    @Override
    public void insert(Widget w, int beforeIndex) {
        positionWidget(w);
        super.insert(w, beforeIndex);
    }
}
