package ru.ncideas.magazinof.gwt.client.modules.catalog.goods.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseToolBarViewIntf;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.GoodsEventBus;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.view.GoodsListToolBarView;


/**
 * @author: mbragin
 * Date: 20.04.12
 * Time: 11:56
 */
@Presenter(view = GoodsListToolBarView.class)
public class GoodsListToolBarPresenter extends BasePresenter<GoodsListToolBarPresenter.IGoodsToolBarView, GoodsEventBus> {

    public interface IGoodsToolBarView extends BaseToolBarViewIntf {
    }

    public void onStart() {
        view.getDeleteButton().setEnabled(false);
        view.getAddButton().setEnabled(true);
        eventBus.changeToolBarPanel(view.getViewWidget());
    }

    @Override
    public void bind() {
        view.getDeleteButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                eventBus.deleteButtonClick();
            }
        });

        view.getAddButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                eventBus.addButtonClick();
            }
        });
    }

    public void onCancelButtonClick() {
        eventBus.changeToolBarPanel(view.getViewWidget());
    }

    public void onListItemsSelected(boolean somethingIsSelected) {
        view.getDeleteButton().setEnabled(somethingIsSelected);
    }
}
