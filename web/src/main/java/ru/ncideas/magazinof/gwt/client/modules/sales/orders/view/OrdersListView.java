package ru.ncideas.magazinof.gwt.client.modules.sales.orders.view;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.dto.OrderDto;
import ru.ncideas.magazinof.gwt.client.components.LinkCellSharp;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.pesenter.OrdersListPresenter;
import ru.ncideas.magazinof.gwt.client.util.TableResources;

import java.util.List;

//created by m.bragin
public class OrdersListView extends Composite implements OrdersListPresenter.IOrdersListView {

    private static final Messages messages = GWT.create(Messages.class);
    private CellTable.Resources resources = GWT.create(TableResources.class);
    private CellTable<OrderDto> table = new CellTable<OrderDto>(20, resources);
    private FlexTable body = new FlexTable();
    private ListDataProvider dataProvider;
    private SelectionModel<OrderDto> selectionModel = new MultiSelectionModel<OrderDto>();


    public OrdersListView() {
        //TODO add search field to search. Search criterias
        initWidget(initLeftPanel());
    }

    private Widget initAdvancedOptions() {
        Grid advancedOptions = new Grid(2, 2);
        advancedOptions.setHTML(0, 0, messages.UserListView_searchOption1Label());
        advancedOptions.setWidget(0, 1, new TextBox());
        advancedOptions.setHTML(1, 0, messages.UserListView_searchOption2Label());
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

    private CellTable<OrderDto> initUserListTable() {

        Column<OrderDto, Boolean> checkColumn = new Column<OrderDto, Boolean>(
                new CheckboxCell(true, false)) {
            @Override
            public Boolean getValue(OrderDto order) {
                // Get the value from the selection model.
                return false;//selectionModel.isSelected(order);
            }
        };

        Column<OrderDto, String> orderNumberColumn = new Column<OrderDto, String>(new LinkCellSharp()) {
            @Override
            public String getValue(OrderDto orderDto) {
                return orderDto.getOrderNumber().toString();
            }
        };

        Column<OrderDto, String> orderDateColumn = new Column<OrderDto, String>(new TextCell()) {
            @Override
            public String getValue(OrderDto orderDto) {
                return DateTimeFormat.getFormat("dd.MM.yyyy HH:mm").format(orderDto.getOrderDate());
            }
        };

        Column<OrderDto, String> deliveryDateColumn = new Column<OrderDto, String>(new TextCell()) {
            @Override
            public String getValue(OrderDto orderDto) {
                return DateTimeFormat.getFormat("dd.MM.yyyy").format(orderDto.getDeliveryDate());
            }
        };

        Column<OrderDto, String> customerColumn = new Column<OrderDto, String>(new TextCell()) {
            @Override
            public String getValue(OrderDto orderDto) {
                return orderDto.getCustomer().getFirstName() + " " + orderDto.getCustomer().getLastName();
            }
        };

        Column<OrderDto, String> statusColumn = new Column<OrderDto, String>(new TextCell()) {
            @Override
            public String getValue(OrderDto orderDto) {
                return orderDto.getStatus().getName();
            }
        };

        //TODO change lables
        table.addColumn(checkColumn);
        table.setColumnWidth(checkColumn, 50, Style.Unit.PX);
        table.addColumn(orderNumberColumn, messages.OrdersListView_orderNumberLabel());
        table.addColumn(orderDateColumn, messages.OrdersListView_orderDate());
        table.addColumn(deliveryDateColumn, messages.OrdersListView_orderDeliveryDate());
        table.addColumn(customerColumn, messages.OrdersListView_customer());
        table.addColumn(statusColumn, messages.OrdersListView_status());

        /*table.setWidth("100%", true);
        table.setColumnWidth(checkColumn, 40.0, Style.Unit.PX);
        table.setColumnWidth(orderNumberColumn, 60.0, Style.Unit.PX);*/

        // Create a data provider.
        dataProvider = new ListDataProvider<OrderDto>();
        // Connect the table to the data provider.
        dataProvider.addDataDisplay(table);

        return table;
    }

    public void loadList(List<OrderDto> orderList) {
        // Add the data to the data provider, which automatically pushes it to the
        // CellTable widget.
        List<OrderDto> list = dataProvider.getList();
        for (OrderDto order : orderList) {
            list.add(order);
        }
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }

    public CellTable<OrderDto> getTable() {
        return table;
    }

    public ListDataProvider getDataProvider() {
        return dataProvider;
    }

    public SelectionModel<OrderDto> getSelectionModel() {
        return selectionModel;
    }

    public void addToolBar(Widget toolBar) {
        body.setWidget(0,0, toolBar);
    }

    @Override
    public void addValueToList(OrderDto value) {
        dataProvider.getList().add(value);

    }

    @Override
    public void updateList(OrderDto value) {
        //TODO implement method

    }

    @Override
    public void removeValueFromList(OrderDto value) {
        //TODO implement method

    }
}
