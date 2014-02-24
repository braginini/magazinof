package ru.ncideas.magazinof.gwt.client.modules.units;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseViewIntf;
import ru.ncideas.magazinof.gwt.client.registry.Registry;
import ru.ncideas.magazinof.gwt.client.registry.RegistryConstants;
import ru.ncideas.magazinof.gwt.util.MenuEnum;

import java.util.Map;

@Presenter(view = UnitsView.class)
public class UnitsPresenter extends
        BasePresenter<UnitsPresenter.IUnitsView, UnitsEventBus> {

    public interface IUnitsView extends BaseViewIntf {

        SimpleLayoutPanel getMainPanel();

        void selectMenuItem(MenuEnum me);

        void mouseOver(MenuEnum me);

        Label getLink(MenuEnum me);

        Map<MenuEnum, Label> getLinks();
    }

    protected static final Messages messages = GWT.create(Messages.class);


    @Override
    public void bind() {
        for (final MenuEnum me : view.getLinks().keySet()) {
            view.getLink(me).addClickHandler(new ClickHandler() {

                @Override
                public void onClick(ClickEvent event) {
                    view.selectMenuItem(me);
                    Registry.register(RegistryConstants.SECOND_LEVEL_MENU_SELECTED, me);
                    switch (me) {
                        default:
                            break;
                    }
                }
            });

            view.getLink(me).addMouseOverHandler(new MouseOverHandler() {
                @Override
                public void onMouseOver(MouseOverEvent mouseOverEvent) {
                    view.mouseOver(me);
                }
            });
        }
    }

    public void onStart() {
        eventBus.changeCenterPanel(view.getViewWidget());
    }

    public void onGoToAdmin() {
        //nothing to do
    }

    public void onGoToUsers() {

    }

    public void onAddToMainPanel(Widget widget) {
        view.getMainPanel().add(widget);
    }

    public void onChangeToolBar(Widget widget) {

    }

}
