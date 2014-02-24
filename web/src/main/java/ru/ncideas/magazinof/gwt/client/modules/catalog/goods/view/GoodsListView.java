package ru.ncideas.magazinof.gwt.client.modules.catalog.goods.view;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.components.LinkCell;
import ru.ncideas.magazinof.gwt.client.dto.GoodDto;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.presenter.GoodsListPresenter;
import ru.ncideas.magazinof.gwt.client.util.TableResources;

import java.util.List;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:55
 */
public class GoodsListView extends Composite implements GoodsListPresenter.IGoodsListView {

    private static final Messages messages = GWT.create(Messages.class);
    private CellTable.Resources resources = GWT.create(TableResources.class);
    private CellTable<GoodDto> table = new CellTable<GoodDto>(20, resources);
    private FlexTable body = new FlexTable();
    private ListDataProvider dataProvider;
    private MultiSelectionModel<GoodDto> selectionModel = new MultiSelectionModel<GoodDto>();


    public GoodsListView() {
        //TODO add search field to search. Search criterias
        initWidget(initLeftPanel());
    }

    private Widget initAdvancedOptions() {
        Grid advancedOptions = new Grid(2, 2);
        advancedOptions.setHTML(0, 0, messages.GoodsListView_searchOption1Label());
        advancedOptions.setWidget(0, 1, new TextBox());
        advancedOptions.setHTML(1, 0, messages.GoodsListView_searchOption2Label());
        advancedOptions.setWidget(1, 1, new TextBox());

        // Add advanced options to form in a disclosure panel
        DisclosurePanel advancedDisclosure = new DisclosurePanel(messages.Common_AdvancedSearch());
        advancedDisclosure.setAnimationEnabled(true);
        advancedDisclosure.setContent(advancedOptions);
        return advancedDisclosure;
    }

    private Widget initLeftPanel() {

        FlexTable.FlexCellFormatter cellFormatter = body.getFlexCellFormatter();
        /*TextBox search = new TextBox();
        body.setHTML(0, 0, messages.UserListView_searchLabel());
        body.setWidget(0, 1, search);*/
        body.setWidget(1, 0, initAdvancedOptions());
        cellFormatter.setColSpan(1, 0, 2);
        body.setWidget(2, 0, initUserListTable());
        cellFormatter.setColSpan(2, 0, 2);

        return body;
    }

    private CellTable<GoodDto> initUserListTable() {

        Column<GoodDto, Boolean> checkColumn = new Column<GoodDto, Boolean>(
                new CheckboxCell(true, false)) {
            @Override
            public Boolean getValue(GoodDto good) {
                // Get the value from the selection model.
                return selectionModel.isSelected(good);
            }
        };

        Column<GoodDto, String> nameColumn = new Column<GoodDto, String>(new LinkCell()) {
            @Override
            public String getValue(GoodDto good) {
                return good.getName();
            }
        };

        Column<GoodDto, String> articleColumn = new Column<GoodDto, String>(new TextCell()) {
            @Override
            public String getValue(GoodDto goodDto) {
                return goodDto.getArticle();
            }
        };

        //TODO change lables
        /*table.setWidth("100%", true);*/
        table.addColumn(checkColumn);
        table.setColumnWidth(checkColumn, 50, Style.Unit.PX);
        table.addColumn(nameColumn, messages.GoodsListView_name());
        table.addColumn(articleColumn, messages.GoodsListView_article());

        /*table.setWidth("100%", true);
        table.setColumnWidth(checkColumn, 40.0, Style.Unit.PX);
        table.setColumnWidth(orderNumberColumn, 60.0, Style.Unit.PX);*/

        // Create a data provider.
        dataProvider = new ListDataProvider<GoodDto>();
        // Connect the table to the data provider.
        dataProvider.addDataDisplay(table);

        return table;
    }

    @Override
    public void loadList(List<GoodDto> userList) {
        // Add the data to the data provider, which automatically pushes it to the
        // CellTable widget.
        List<GoodDto> list = dataProvider.getList();
        for (GoodDto good : userList) {
            list.add(good);
        }
    }

    public void addValueToList(GoodDto goodDto) {
        dataProvider.getList().add(goodDto);
    }

    @Override
    public void updateList(GoodDto value) {
        for (Object o : dataProvider.getList()) {
            if (((GoodDto) o).getId() == value.getId()) {
                int index = dataProvider.getList().indexOf(o);
                dataProvider.getList().remove(o);
                dataProvider.getList().add(index, value);
            }
        }

    }

    @Override
    public void removeValueFromList(GoodDto value) {
        dataProvider.getList().remove(value);
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }

    public CellTable<GoodDto> getTable() {
        return table;
    }

    public ListDataProvider getDataProvider() {
        return dataProvider;
    }

    public SelectionModel<GoodDto> getSelectionModel() {
        return selectionModel;
    }

    public void addToolBar(Widget toolBar) {
        body.setWidget(0, 0, toolBar);
    }
}
