package ru.ncideas.magazinof.gwt.client.modules.base.abstracts;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;

public abstract class AbstractBaseSubModuleView extends Composite {

    protected DockLayoutPanel body = new DockLayoutPanel(Style.Unit.PX);
    protected SimpleLayoutPanel toolBarPanel = new SimpleLayoutPanel();
    protected ScrollPanel mainPanel = new ScrollPanel();

    protected AbstractBaseSubModuleView() {
        //splitPanel.setStyleName("mainPanel");

        body.setStyleName("mf-subModuleBody");
        /*body.addNorth(toolBarPanel, 30);
        //splitPanel - west panel is list panel (e.g. users list, org list)
        //detail panel is added on center of splitPanel
        //splitPanel created for separating list from details with a splitter
        splitPanel.addWest(listPanel, 400);
        //detail panel - first (north) panel is simple details panel (e.g. user's first name, last name, email),
        //second(center) panel is more complex details panel  (e.g. user's organizations, roles etc.)
        //both panels are created for placing views on em (e.g. on first - UserDetailView, second - UserOrgView)
        //detailPanel.addWest(firstSubDetailPanel, 300);
        //detailPanel.add(secondSubDetailPanel);

        splitPanel.add(detailPanel);
        body.add(splitPanel);*/
        mainPanel.setStyleName("mf-mainSubModulePanel");
        body.addNorth(toolBarPanel, 37);
        body.add(mainPanel);

        initWidget(body);
    }

    public DockLayoutPanel getBody() {
        return body;
    }

    public SimpleLayoutPanel getToolBarPanel() {
        return toolBarPanel;
    }

    public ScrollPanel getMainPanel() {
        return mainPanel;
    }

    /*//if you need second sub detail panel, you should add it manually
    protected void addSecondSubDetailPanel(int size) {
        detailPanel.addWest(secondSubDetailPanel, size);
    }

    //if you do not need to add second detail panel you should use this method to add
    //first detail panel
    protected void addFirstSubDetailPanel() {
        detailPanel.add(firstSubDetailPanel);
    }

    //if you need to add more than one detail panel you should use this method
    protected void addFirstSubDetailPanel(int size) {
        detailPanel.addWest(firstSubDetailPanel,size);
    }*/

    //adds widget to detail panel with specified size
    //you can add widgets one by one using this method
   /* public void addPanelToDetailPanel(Widget widget, int size) {
       detailPanel.addWest(widget, size);
    }*/

    //adds only one widget to detail panel, that takes all remaining space of detail panel
    //aftter using this method you can not add any widget to detail panel
    /*public void addPanelToDetailPanel(Widget widget) {
       detailPanel.add(widget);
    }*/
}