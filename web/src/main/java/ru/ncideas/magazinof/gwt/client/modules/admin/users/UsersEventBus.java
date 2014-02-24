package ru.ncideas.magazinof.gwt.client.modules.admin.users;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;
import ru.ncideas.magazinof.gwt.client.dto.AccountDto;
import ru.ncideas.magazinof.gwt.client.dto.UserDto;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.presenter.*;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.view.UsersRootView;

/**
 * Author: Dmitry Naumov
 * Date: 20.04.12
 * Time: 11:54
 */
@Events(startView = UsersRootView.class, module = UsersModule.class)
public interface UsersEventBus extends EventBus {

    //views initialization events
    @Event(forwardToParent = true)
    public void addToMainPanel(Widget widget);

    @Event(handlers = UsersRootPresenter.class)
    void changeMainPanel(Widget widget);

    @Event(handlers = UsersRootPresenter.class)
    void changeToolBarPanel(Widget widget);

    @Event
    public void goToUsers();

    //start module event
    @Start
    @Event(handlers = {
            UsersRootPresenter.class,
            UsersListPresenter.class,
            UsersListToolBarPresenter.class,
            UsersDetailPresenter.class,
            UsersDetailToolBarPresenter.class})
    public void start();

    //action events
    @Event(handlers = {
            UsersDetailToolBarPresenter.class,
            UsersDetailPresenter.class })
    void clickUser(UserDto user);

    @Event(handlers = {
            UsersListPresenter.class })
    void clickUserEmail(UserDto user);

    @Event(handlers = {
            UsersListPresenter.class,
            UsersListToolBarPresenter.class})
    void cancelButtonClick();

    @Event(handlers = {
            UsersListPresenter.class,
            UsersListToolBarPresenter.class})
    void saveButtonClick();

    @Event(handlers = {
            UsersListPresenter.class})
    void accountReceived(AccountDto accountDto);

    @Event(handlers = {
            UsersDetailToolBarPresenter.class,
            UsersDetailPresenter.class })
    void addButtonClick();
}
