package ru.ncideas.magazinof.gwt.client.modules.units;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.modules.base.abstracts.AbstractBaseModuleView;
import ru.ncideas.magazinof.gwt.util.MenuEnum;

public class UnitsView extends AbstractBaseModuleView implements UnitsPresenter.IUnitsView {

	public UnitsView() {
		   addItemsToLeftMenu();
    }

    private void addItemsToLeftMenu() {
        for (MenuEnum me : getModuleMenuItems()) {
            String tabName;
            switch (me) {
                default:
                    tabName = me.getMenuItem().getName();
            }
            Label label = new Label(tabName);
            links.put(me, label);
            menuPanel.add(label);
        }
        setMenuItemsStyles();
    }

    @Override
    public Widget getViewWidget() {
        // TODO Auto-generated method stub
        return this;
    }

}