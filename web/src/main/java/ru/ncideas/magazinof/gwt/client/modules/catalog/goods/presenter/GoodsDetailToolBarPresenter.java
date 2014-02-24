package ru.ncideas.magazinof.gwt.client.modules.catalog.goods.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.dto.GoodDto;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseToolBarViewIntf;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.GoodsEventBus;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.view.GoodsDetailToolBarView;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:56
 */
@Presenter(view = GoodsDetailToolBarView.class)
public class GoodsDetailToolBarPresenter extends BasePresenter<GoodsDetailToolBarPresenter.IGoodsDetailToolBarView, GoodsEventBus> {

    public interface IGoodsDetailToolBarView extends BaseToolBarViewIntf {

        Button getSaveButton();

        Button getCancelButton();
    }

    public void onStart() {
        //eventBus.changeOrdersDetailToolBar(view.getViewWidget());
    }

    @Override
    public void bind() {
        view.getSaveButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                //TODO invoke changes check method (implement this method), if changes were made, show "SAVE or NOT" window
                eventBus.saveButtonClick();
            }
        });

        view.getCancelButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                //TODO invoke changes check method (implement this method), if changes were made, show "SAVE or NOT" window
                eventBus.cancelButtonClick();
            }
        });
    }

    public void onClickGood(GoodDto user) {
        eventBus.changeToolBarPanel(view.getViewWidget());
        //TODO логика тулбара (подсветка кнопок и тд).
    }

    public void onAddButtonClick() {
        eventBus.changeToolBarPanel(view.getViewWidget());
    }
}
