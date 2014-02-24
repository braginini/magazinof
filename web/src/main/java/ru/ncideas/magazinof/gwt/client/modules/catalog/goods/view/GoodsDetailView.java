package ru.ncideas.magazinof.gwt.client.modules.catalog.goods.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomListBox;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomTextBox;
import ru.ncideas.magazinof.gwt.client.components.forms.ContentPanel;
import ru.ncideas.magazinof.gwt.client.components.forms.Orientation;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.presenter.GoodsDetailPresenter;

/**
 * @author: mbragin
 * Date: 08.06.12
 * Time: 11:00
 */
public class GoodsDetailView extends Composite implements GoodsDetailPresenter.IGoodsDetailView {

    private static final Messages messages = GWT.create(Messages.class);

    private CustomTextBox name = new CustomTextBox();
    private CustomTextBox article = new CustomTextBox();
    private CustomTextBox description = new CustomTextBox();
    private CustomListBox measure = new CustomListBox();

    public GoodsDetailView() {
        initWidget(initMainPanel());
    }

    private Widget initMainPanel() {
        ContentPanel mainPanel = new ContentPanel(Orientation.VERTICAL);

        article.setContentBoxStyle("mf-contentbox");
        article.setFieldLabel(messages.GoodsDetailView_article());
        name.setFieldLabel(messages.GoodsDetailView_name());
        name.setContentBoxStyle("mf-contentbox");
        description.setFieldLabel(messages.GoodsDetailView_description());
        description.setContentBoxStyle("mf-contentbox-wide");
        measure.setFieldLabel(messages.GoodsDetailView_measure());
        measure.setContentBoxStyle("mf-contentbox");

        mainPanel.add(article);
        mainPanel.add(name);
        mainPanel.add(description);
        mainPanel.add(measure);

        return mainPanel;
    }

    private void initCommonFields() {
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }

    @Override
    public CustomTextBox getName() {
        return name;
    }

    @Override
    public CustomTextBox getArticle() {
        return article;
    }

    @Override
    public CustomTextBox getDescription() {
        return description;
    }

    @Override
    public CustomListBox getMeasure() {
        return measure;
    }
}
