package ru.ncideas.magazinof.gwt.client.modules.admin.users.view;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.components.LinkCell;
import ru.ncideas.magazinof.gwt.client.components.LinkCellEmail;
import ru.ncideas.magazinof.gwt.client.dto.OrderDto;
import ru.ncideas.magazinof.gwt.client.dto.UserDto;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.presenter.UsersListPresenter;
import ru.ncideas.magazinof.gwt.client.util.TableResources;

import java.util.List;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:55
 */
public class UsersListView extends Composite implements UsersListPresenter.IUsersListView {

    private static final Messages messages = GWT.create(Messages.class);
    private CellTable.Resources resources = GWT.create(TableResources.class);
    private CellTable<UserDto> table = new CellTable<UserDto>(20, resources);
    private FlexTable body = new FlexTable();
    private ListDataProvider dataProvider;
    private SelectionModel<UserDto> selectionModel = new MultiSelectionModel<UserDto>();


    public UsersListView() {
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

    private CellTable<UserDto> initUserListTable() {

        Column<UserDto, Boolean> checkColumn = new Column<UserDto, Boolean>(
                new CheckboxCell(true, false)) {
            @Override
            public Boolean getValue(UserDto order) {
                // Get the value from the selection model.
                return false;//selectionModel.isSelected(order);
            }
        };

        Column<UserDto, String> usernameColumn = new Column<UserDto, String>(new LinkCell()) {
            @Override
            public String getValue(UserDto userDto) {
                return userDto.getUsername();
            }
        };

        Column<UserDto, String> nameColumn = new Column<UserDto, String>(new TextCell()) {
            @Override
            public String getValue(UserDto userDto) {
                return userDto.getFirst_name() + " " + userDto.getLast_name();
            }
        };

        Column<UserDto, String> emailColumn = new Column<UserDto, String>(new LinkCellEmail()) {
            @Override
            public String getValue(UserDto userDto) {
                return userDto.getEmail();
            }
        };

        Column<UserDto, String> createdDateColumn = new Column<UserDto, String>(new TextCell()) {
            @Override
            public String getValue(UserDto userDto) {
                return DateTimeFormat.getFormat("dd.MM.yyyy HH:mm").format((userDto.getCreated()));
            }
        };

        Column<UserDto, String> lastLoggedDateColumn = new Column<UserDto, String>(new TextCell()) {
            @Override
            public String getValue(UserDto userDto) {
                return DateTimeFormat.getFormat("dd.MM.yyyy HH:mm").format((userDto.getLastLogged()));
            }
        };

        Column<UserDto, String> statusColumn = new Column<UserDto, String>(new TextCell()) {
            @Override
            public String getValue(UserDto userDto) {
                return userDto.getStatus().getName();
            }
        };

        //TODO change lables
        table.addColumn(checkColumn);
        table.addColumn(usernameColumn, messages.UserListView_username());
        table.addColumn(nameColumn, messages.UserListView_name());
        table.addColumn(emailColumn, messages.UserListView_email());
        table.addColumn(createdDateColumn, messages.UserListView_created());
        table.addColumn(lastLoggedDateColumn, messages.UserListView_lastLogged());
        table.addColumn(statusColumn, messages.UserListView_status());

        /*table.setWidth("100%", true);
        table.setColumnWidth(checkColumn, 40.0, Style.Unit.PX);
        table.setColumnWidth(orderNumberColumn, 60.0, Style.Unit.PX);*/

        // Create a data provider.
        dataProvider = new ListDataProvider<OrderDto>();
        // Connect the table to the data provider.
        dataProvider.addDataDisplay(table);

        return table;
    }

    public void loadList(List<UserDto> userList) {
        // Add the data to the data provider, which automatically pushes it to the
        // CellTable widget.
        List<UserDto> list = dataProvider.getList();
        for (UserDto user : userList) {
            list.add(user);
        }
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }

    public CellTable<UserDto> getTable() {
        return table;
    }

    public ListDataProvider getDataProvider() {
        return dataProvider;
    }

    public SelectionModel<UserDto> getSelectionModel() {
        return selectionModel;
    }

    public void addToolBar(Widget toolBar) {
        body.setWidget(0,0, toolBar);
    }

    @Override
    public void addValueToList(UserDto value) {
        dataProvider.getList().add(value);

    }

    @Override
    public void updateList(UserDto value) {
        //TODO implement method

    }

    @Override
    public void removeValueFromList(UserDto value) {
        //TODO implement method

    }
}
