package ru.ncideas.magazinof.gwt.client.modules.root;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.*;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.registry.Registry;
import ru.ncideas.magazinof.gwt.client.registry.RegistryConstants;
import ru.ncideas.magazinof.gwt.util.MenuEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RootView extends Composite implements RootPresenter.IRootView {

    private static final Messages messages = GWT.create(Messages.class);

    private DockLayoutPanel body = new DockLayoutPanel(Unit.PX);
    private FlowPanel mainHeader = new FlowPanel();
    private FlowPanel headerToolbar = new FlowPanel();
    private FlowPanel headerToolbarContainer = new FlowPanel();
    private FlowPanel headerToolbarContainerRight = new FlowPanel();
    private FlowPanel tray = new FlowPanel();
    private FlowPanel footer = new FlowPanel();
    private SimplePanel mainPanel = new SimplePanel();
    private Label logoutLink;

    private Map<MenuEnum, Label> tabs;

    public RootView() {
        body.addNorth(initHeaderToolbar(), 40);
        body.addNorth(initMainHeader(), 90);
        body.addSouth(initFooter(), 50);
        body.add(mainPanel);
        initWidget(body);
    }

    private FlowPanel initHeaderToolbar() {
        headerToolbarContainer.setStyleName("mf-header-toolbar-container");
        headerToolbarContainer.add(new Label("MagazinOF"));
        headerToolbarContainerRight.setStyleName("mf-header-toolbar-container-right");

        logoutLink = new Label("Logout");
        logoutLink.setStyleName("mf-logout-link");

        headerToolbarContainerRight.add(logoutLink);
        headerToolbar.add(headerToolbarContainer);
        headerToolbar.add(headerToolbarContainerRight);
        headerToolbar.setStyleName("mf-header-toolbar");
        return headerToolbar;
    }

    private FlowPanel initMainHeader() {
        mainHeader.setStyleName("header-main");
        mainHeader.add(initHeader());
        return mainHeader;
    }

    private FlowPanel initHeader() {
        //tray.setSpacing(20);
        //tray.setSize("100%", "100%");

        tabs = new HashMap<MenuEnum, Label>();
        for (MenuEnum me : (List<MenuEnum>) Registry.get(RegistryConstants.TOP_LEVEL_MENU)) {
            String tabName;
            switch (me) {
                case HOME:
                    tabName = messages.RootView_homeTab();
                    break;
                case SALES:
                    tabName = messages.RootView_salesTab();
                    break;
                case SHIPPING:
                    tabName = messages.RootView_shippingTab();
                    break;
                case ORGANIZATION:
                    tabName = messages.RootView_organizationTab();
                    break;
                case WAREHOUSES:
                    tabName = messages.RootView_warehousesTab();
                    break;
                case CATALOG:
                    tabName = messages.RootView_catalogTab();
                    break;
                case REPORTS:
                    tabName = messages.RootView_reportsTab();
                    break;
                case ADMINISTRATION:
                    tabName = messages.RootView_administrationTab();
                    break;
                default:
                    tabName = me.getMenuItem().getName();
            }
            Label tab = new Label(tabName);
            tabs.put(me, tab);
            addTab(tab);
        }

        tray.setStyleName("tray");
        return tray;
    }

    private FlowPanel initFooter() {
        footer.setSize("100%", "100%");
        footer.setStyleName("footer");
        return footer;

    }

    public FlowPanel getTray() {
        return tray;
    }

    public FlowPanel getFooter() {
        return footer;
    }

    public SimplePanel getMainPanel() {
        return mainPanel;
    }

    public void addTab(Label tab) {
        tab.setStyleName("tab");
        tray.add(tab);
    }

    public void selectTab(MenuEnum me) {
        removeTabsSelectStyle();
        tabs.get(me).addStyleName("selected");
    }

    public Label getTab(MenuEnum me) {
        return tabs.get(me);
    }

    public void removeTabsSelectStyle() {
        for (Label tab : tabs.values()) {
            tab.removeStyleName("selected");
        }
    }

    public Map<MenuEnum, Label> getTabs() {
        return tabs;
    }

    public Label getLogoutLink() {
        return logoutLink;
    }
}
