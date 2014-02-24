package ru.ncideas.magazinof.gwt.client.modules.catalog;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.annotation.module.ChildModule;
import com.mvp4g.client.annotation.module.ChildModules;
import com.mvp4g.client.annotation.module.DisplayChildModuleView;
import com.mvp4g.client.event.EventBus;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.GoodsModule;

@Events(startView = CatalogView.class, module = CatalogModule.class)
@ChildModules({
        @ChildModule(moduleClass = GoodsModule.class)})
public interface CatalogEventBus extends EventBus {

    @Event
    public void goToCatalog();

    @Event(forwardToParent = true)
    public void changeCenterPanel(Widget viewWidget);

    @Event(modulesToLoad = GoodsModule.class)
    public void goToGoods();

    @DisplayChildModuleView(value = {GoodsModule.class})
    @Event(handlers = CatalogPresenter.class)
    public void addToMainPanel(Widget widget);

    @Start
    @Event(handlers = CatalogPresenter.class)
    public void start();
}
