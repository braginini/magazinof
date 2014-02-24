package ru.ncideas.magazinof.gwt.client.modules.catalog.goods.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.modules.base.abstracts.AbstractBaseToolbarView;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.presenter.GoodsListToolBarPresenter;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:55
 */
public class GoodsListToolBarView extends AbstractBaseToolbarView implements GoodsListToolBarPresenter.IGoodsToolBarView {

    private static final Messages messages = GWT.create(Messages.class);


    public GoodsListToolBarView() {
        super();
        addAddButton(messages.Common_Add());
        addDeleteButton(messages.Common_Delete());
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }
}
