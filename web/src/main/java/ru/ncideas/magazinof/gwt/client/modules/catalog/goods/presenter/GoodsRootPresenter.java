package ru.ncideas.magazinof.gwt.client.modules.catalog.goods.presenter;

import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseViewIntf;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.GoodsEventBus;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.view.GoodsRootView;

/**
 * @author: mbragin
 * Date: 20.04.12
 * Time: 11:56
 */
@Presenter(view = GoodsRootView.class)
public class GoodsRootPresenter extends BasePresenter<GoodsRootPresenter.IGoodsRootView, GoodsEventBus> {

    public interface IGoodsRootView extends BaseViewIntf {

        ScrollPanel getMainPanel();
        SimpleLayoutPanel getToolBarPanel();
    }

    public void onStart() {
        eventBus.addToMainPanel(view.getViewWidget());

    }

    /*public void onChangeListPanel(Widget widget) {
        view.getListPanel().setWidget(widget);
    }*/

    public void onChangeMainPanel(Widget widget) {
        view.getMainPanel().setWidget(widget);
    }

    /*public void onChangeFirstDetailPanel(Widget widget) {
        view.getFirstDetailPanel().setWidget(widget);
    }*/

    public void onChangeToolBarPanel(Widget widget) {
        view.getToolBarPanel().setWidget(widget);
    }

}
