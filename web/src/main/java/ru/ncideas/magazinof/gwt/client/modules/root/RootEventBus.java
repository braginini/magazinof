package ru.ncideas.magazinof.gwt.client.modules.root;

import ru.ncideas.magazinof.gwt.client.modules.admin.AdminModule;
import ru.ncideas.magazinof.gwt.client.modules.catalog.CatalogModule;
import ru.ncideas.magazinof.gwt.client.modules.home.HomeModule;
import ru.ncideas.magazinof.gwt.client.modules.sales.SalesModule;
import ru.ncideas.magazinof.gwt.client.modules.units.UnitsModule;
import ru.ncideas.magazinof.gwt.client.modules.warehouses.WarehousesModule;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.annotation.module.ChildModule;
import com.mvp4g.client.annotation.module.ChildModules;
import com.mvp4g.client.event.EventBus;
import com.mvp4g.client.annotation.module.DisplayChildModuleView;

@Events(startView = RootView.class)
@ChildModules({@ChildModule(moduleClass = AdminModule.class),
        @ChildModule(moduleClass = HomeModule.class),
        @ChildModule(moduleClass = UnitsModule.class),
        @ChildModule(moduleClass = CatalogModule.class),
        @ChildModule(moduleClass = WarehousesModule.class),
        @ChildModule(moduleClass = SalesModule.class)})
public interface RootEventBus extends EventBus {

    //navigation events (header - topMenu)
    @Event(modulesToLoad = HomeModule.class, handlers = RootPresenter.class)
    public void goToHome();

    @Event(modulesToLoad = SalesModule.class, handlers = RootPresenter.class)
    public void goToSales();

    @Event(handlers = RootPresenter.class)
    public void goToShipping();

    @Event(handlers = RootPresenter.class)
    public void goToOrganization();

    @Event(modulesToLoad = WarehousesModule.class, handlers = RootPresenter.class)
    public void goToWarehouses();

    @Event(modulesToLoad = CatalogModule.class, handlers = RootPresenter.class)
    public void goToCatalog();

    @Event(handlers = RootPresenter.class)
    public void goToReports();

    @Event(modulesToLoad = AdminModule.class, handlers = RootPresenter.class)
    public void goToAdministration();

    //display modules event
    @DisplayChildModuleView(value = {AdminModule.class,
            HomeModule.class,
            UnitsModule.class,
            CatalogModule.class,
            WarehousesModule.class,
            SalesModule.class})
    @Event(handlers = RootPresenter.class)
    public void changeCenterPanel(Widget widget);

    @Start
    @Event(handlers = {RootPresenter.class})
    public void start();
}
