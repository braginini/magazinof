package ru.ncideas.magazinof.gwt.client.modules.root;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.dto.AccountDto;
import ru.ncideas.magazinof.gwt.client.registry.Registry;
import ru.ncideas.magazinof.gwt.client.registry.RegistryConstants;
import ru.ncideas.magazinof.gwt.client.services.RpcSessionServiceAsync;
import ru.ncideas.magazinof.gwt.util.MenuEnum;

import java.util.Map;

import static ru.ncideas.magazinof.gwt.util.MenuEnum.*;


@Presenter(view = RootView.class)
public class RootPresenter extends
		BasePresenter<RootPresenter.IRootView, RootEventBus> {

	@Inject
	private RpcSessionServiceAsync service;

	public interface IRootView {

        Label getTab(MenuEnum me);

		void selectTab(MenuEnum me);

        SimplePanel getMainPanel();

        Map<MenuEnum, Label> getTabs();

        Label getLogoutLink();
	}

	public void onStart() {
        service.getAccount(new AsyncCallback<AccountDto>() {
            @Override
            public void onFailure(Throwable caught) {
                System.out.println(caught.getMessage());
            }

            @Override
            public void onSuccess(AccountDto result) {
                initMenu();
            }
        });

	}

    @Override
    public void bind() {
        view.getLogoutLink().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                service.logout(new AsyncCallback<Void>() {
                    @Override
                    public void onSuccess(Void result) {
                        Window.Location.reload();
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                    }

                });
            }
        });
    }

    private void initMenu() {
        for (final MenuEnum me : view.getTabs().keySet())  {
            view.getTab(me).addClickHandler(new ClickHandler() {

                @Override
                public void onClick(ClickEvent event) {
                    Registry.register(RegistryConstants.TOP_LEVEL_MENU_SELECTED, me);
                    switch (me) {
                        case HOME:
                            eventBus.goToHome();
                            break;
                        case SALES:
                            eventBus.goToSales();
                            break;
                        case SHIPPING:
                            eventBus.goToShipping();
                            break;
                        case ORGANIZATION:
                            eventBus.goToOrganization();
                            break;
                        case WAREHOUSES:
                            eventBus.goToWarehouses();
                            break;
                        case CATALOG:
                            eventBus.goToCatalog();
                            break;
                        case REPORTS:
                            eventBus.goToReports();
                            break;
                        case ADMINISTRATION:
                            eventBus.goToAdministration();
                            break;
                    }
                }
            });
        }
    }

    public void onChangeCenterPanel(Widget widget) {
        view.getMainPanel().setWidget(widget);
	}

    public void onGoToHome(){
		view.selectTab(HOME);
	}

	public void onGoToOrders(){
		view.selectTab(ORDERS);
	}

    public void onGoToShipping(){
		view.selectTab(SHIPPING);
	}

    public void onGoToOrganization(){
		view.selectTab(ORGANIZATION);
	}

    public void onGoToWarehouses(){
		view.selectTab(WAREHOUSES);
	}

    public void onGoToCatalog(){
		view.selectTab(CATALOG);
	}

    public void onGoToReports(){
		view.selectTab(REPORTS);
	}

    public void onGoToAdministration(){
		view.selectTab(ADMINISTRATION);
	}

     public void onGoToSales(){
		view.selectTab(SALES);
	}
}
