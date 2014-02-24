package ru.ncideas.magazinof.gwt.client.modules.base.abstracts;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.registry.Registry;
import ru.ncideas.magazinof.gwt.client.registry.RegistryConstants;
import ru.ncideas.magazinof.gwt.util.MenuEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBaseModuleView extends Composite {
    //TODO remove toolbar main; make body simplepanel
    protected static final Messages messages = GWT.create(Messages.class);
    protected DockLayoutPanel body = new DockLayoutPanel(Style.Unit.PX);
    protected FlowPanel menuPanel = new FlowPanel();
    protected SimpleLayoutPanel mainPanel = new SimpleLayoutPanel();

    protected List<MenuEnum> moduleMenuItems;
    protected Map<MenuEnum, Label> links = new HashMap<MenuEnum, Label>();

    public AbstractBaseModuleView() {
        initModuleMenu();
        body.setStyleName("mf-moduleBody");
        body.addNorth(initMenuPanel(), 37);
        body.add(initMainPanel());
        initWidget(body);
    }

    public void initModuleMenu() {
        MenuEnum me = Registry.get(RegistryConstants.TOP_LEVEL_MENU_SELECTED);
        moduleMenuItems = Registry.get(RegistryConstants.SECOND_LEVEL_MENU + me);
    }

    public List<MenuEnum> getModuleMenuItems() {
        return moduleMenuItems;
    }

    protected FlowPanel initMenuPanel() {
        menuPanel.setStyleName("menu-sub");
        return menuPanel;
    }

    protected SimpleLayoutPanel initMainPanel() {
        mainPanel.setStyleName("mf-module-container");
        return mainPanel;
    }

    public SimpleLayoutPanel getMainPanel() {
        return mainPanel;
    }

    public FlowPanel getMenuPanel() {
        return menuPanel;
    }

    public Label getLink(MenuEnum me) {
        return links.get(me);
    }

    public Map<MenuEnum, Label> getLinks() {
        return links;
    }

    public void selectMenuItem(MenuEnum me) {
        for (Label label : links.values()) {
            label.removeStyleName("menu-sub-item-selected");
        }
        links.get(me).addStyleName("menu-sub-item-selected");
    }

    public void mouseOver(MenuEnum me) {
        /*for (Label label : links.values()) {
            label.removeStyleName("secondMenuHoveredRow");
        }
        links.get(me).addStyleName("secondMenuHoveredRow");*/
    }

    public void setMenuItemsStyles() {
        for (Label label : links.values()) {
            label.addStyleName("menu-sub-item");
        }
    }

}
