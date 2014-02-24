package ru.ncideas.magazinof.gwt.client.components.forms;

import com.google.gwt.user.client.ui.Widget;

/**
 * User: mbragin
 * Date: 07.06.12
 * Time: 17:57
 */
public class DecoratedContentPanel extends ContentPanel {

    public ContentPanel header = new ContentPanel(Orientation.HORIZONTAL);
    public ContentPanel body = new ContentPanel(Orientation.VERTICAL);

    public DecoratedContentPanel() {
        setHeaderStyles();
    }

    private void setHeaderStyles() {
        header.removeStyleName("mf-content-panel");
        header.addStyleName("mf-decorated-content-panel");
    }

    public DecoratedContentPanel(Orientation orientation) {
        body.setOrientation(orientation);
    }

    @Override
    public void setOrientation(Orientation orientation) {
        body.setOrientation(orientation);
    }

    @Override
    public void add(Widget w) {
        body.add(w);
    }

    @Override
    public void insert(Widget w, int beforeIndex) {
        body.insert(w, beforeIndex);
    }
}
