package ru.ncideas.magazinof.gwt.client.modules.catalog.goods;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;
import ru.ncideas.magazinof.gwt.client.dto.AccountDto;
import ru.ncideas.magazinof.gwt.client.dto.GoodDto;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.presenter.*;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.view.GoodsRootView;

import java.util.Set;

/**
 * Author: Dmitry Naumov
 */
@Events(startView = GoodsRootView.class, module = GoodsModule.class)
public interface GoodsEventBus extends EventBus {

    //views initialization events
    @Event(forwardToParent = true)
    public void addToMainPanel(Widget widget);

    @Event(handlers = GoodsRootPresenter.class)
    void changeMainPanel(Widget widget);

    @Event(handlers = GoodsRootPresenter.class)
    void changeToolBarPanel(Widget widget);

    @Event
    public void goToGoods();

    //start module event
    @Start
    @Event(handlers = {
            GoodsRootPresenter.class,
            GoodsListPresenter.class,
            GoodsListToolBarPresenter.class,
            GoodsDetailPresenter.class,
            GoodsDetailToolBarPresenter.class})
    public void start();

    //action events
    @Event(handlers = {
            GoodsDetailToolBarPresenter.class,
            GoodsDetailPresenter.class})
    void clickGood(GoodDto goodDto);

    @Event(handlers = {
            GoodsDetailPresenter.class,
            GoodsListPresenter.class,
            GoodsListToolBarPresenter.class})
    void cancelButtonClick();

    @Event(handlers = {
            GoodsDetailPresenter.class})
    void saveButtonClick();

    @Event(handlers = {
            GoodsListPresenter.class})
    void accountReceived(AccountDto accountDto);

    @Event(handlers = {
            GoodsDetailToolBarPresenter.class,
            GoodsDetailPresenter.class})
    void addButtonClick();

    @Event(handlers = {
            GoodsDetailPresenter.class,
            GoodsListPresenter.class})
    void newGoodAdded(GoodDto newGood);

    @Event(handlers = {
            GoodsDetailPresenter.class,
            GoodsListPresenter.class})
    void goodUpdated(GoodDto newGood);

    @Event(handlers = {
            GoodsListPresenter.class})
    void deleteButtonClick();

    @Event(handlers = {
            GoodsListPresenter.class})
    void goodsDeleted(Set<GoodDto> deletedGoods);

    @Event(handlers = {
                GoodsListToolBarPresenter.class})
    void listItemsSelected(boolean somethingIsSelected);
}
