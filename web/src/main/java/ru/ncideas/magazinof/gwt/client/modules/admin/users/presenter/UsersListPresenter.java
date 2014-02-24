package ru.ncideas.magazinof.gwt.client.modules.admin.users.presenter;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.CellPreviewEvent;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.components.LinkCell;
import ru.ncideas.magazinof.gwt.client.components.LinkCellEmail;
import ru.ncideas.magazinof.gwt.client.dto.AccountDto;
import ru.ncideas.magazinof.gwt.client.dto.UserDto;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.UsersEventBus;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.view.UsersListView;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseListViewIntf;
import ru.ncideas.magazinof.gwt.client.services.RpcAdminModuleServiceAsync;
import ru.ncideas.magazinof.gwt.client.services.RpcSessionServiceAsync;

import javax.inject.Inject;
import java.util.List;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:56
 */
@Presenter(view = UsersListView.class)
public class UsersListPresenter extends BasePresenter<UsersListPresenter.IUsersListView, UsersEventBus> {
    public interface IUsersListView extends BaseListViewIntf<UserDto> {

    }

    @Inject
    RpcAdminModuleServiceAsync service;

    @Inject
    RpcSessionServiceAsync sessionService;

    @Override
    public void bind() {
        view.getTable().addCellPreviewHandler(new CellPreviewEvent.Handler<UserDto>() {
            @Override
            public void onCellPreview(CellPreviewEvent<UserDto> event) {
                boolean isClickEvent = "click".equals(event.getNativeEvent().getType());
                Cell clickedCell = view.getTable().getColumn(event.getColumn()).getCell();
                if (isClickEvent) {
                    if (isLinkCell(clickedCell)) {
                        eventBus.clickUser(event.getValue());
                    } else if (isLinkCellMailto(clickedCell)) {
                        eventBus.clickUserEmail(event.getValue());
                    }
                }

            }
        });
    }

    private boolean isLinkCell(Cell clickedCell) {
        return (clickedCell.getClass().equals(LinkCell.class)) ? true : false;
    }

    private boolean isLinkCellMailto(Cell clickedCell) {
        return (clickedCell.getClass().equals(LinkCellEmail.class)) ? true : false;
    }

    public void onStart() {
        loadUsersList();
        eventBus.changeMainPanel(view.getViewWidget());
    }

    private void loadUsersList() {
        sessionService.getAccount(new AsyncCallback<AccountDto>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(AccountDto result) {
                eventBus.accountReceived(result);
            }
        });
    }

    public void onSaveButtonClick() {
        eventBus.changeMainPanel(view.getViewWidget());
    }


    public void onCancelButtonClick() {
        eventBus.changeMainPanel(view.getViewWidget());
    }

    public void onClickUserEmail(UserDto userDto){
        Window.open("mailto:" + userDto.getEmail(), "_blank", "");
    }

    public void onAccountReceived(AccountDto accountDto) {
        service.findUsersByAccount(accountDto, new AsyncCallback<List<UserDto>>() {

            @Override
            public void onFailure(Throwable caught) {
                GWT.log("RPC ERROR : " + this.getClass().getName() + " service findUsersByAccount error", caught);
            }

            @Override
            public void onSuccess(List<UserDto> result) {
                GWT.log("RPC SUCCESS : " + this.getClass().getName() + "findUsersByAccount OrderList successfully loaded");
                view.loadList(result);
            }
        });
    }
}
