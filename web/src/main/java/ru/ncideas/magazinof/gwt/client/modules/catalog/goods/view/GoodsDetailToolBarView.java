package ru.ncideas.magazinof.gwt.client.modules.catalog.goods.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.modules.base.abstracts.AbstractBaseToolbarView;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.presenter.GoodsDetailToolBarPresenter;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:55
 */
public class GoodsDetailToolBarView extends AbstractBaseToolbarView implements GoodsDetailToolBarPresenter.IGoodsDetailToolBarView {

    private static final Messages messages = GWT.create(Messages.class);

    public GoodsDetailToolBarView() {
        addSaveButton(messages.Common_Save());
        addCancelButton(messages.Common_Cancel());
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }
}
