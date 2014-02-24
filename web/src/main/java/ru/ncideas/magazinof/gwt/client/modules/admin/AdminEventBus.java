package ru.ncideas.magazinof.gwt.client.modules.admin;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.annotation.module.ChildModule;
import com.mvp4g.client.annotation.module.ChildModules;
import com.mvp4g.client.annotation.module.DisplayChildModuleView;
import com.mvp4g.client.event.EventBus;
import ru.ncideas.magazinof.gwt.client.modules.admin.settings.SettingsModule;
import ru.ncideas.magazinof.gwt.client.modules.admin.users.UsersModule;

@Events(startView = AdminView.class, module = AdminModule.class)
@ChildModules({
        @ChildModule(moduleClass = UsersModule.class),
        @ChildModule(moduleClass = SettingsModule.class)})
public interface AdminEventBus extends EventBus {

    @Event
    public void goToAdministration();

    @Event(forwardToParent = true)
    public void changeCenterPanel(Widget viewWidget);

    @Event(modulesToLoad = UsersModule.class)
    public void goToUsers();

    @Event(modulesToLoad = SettingsModule.class)
    public void goToSettings();

    @DisplayChildModuleView(value = {UsersModule.class, SettingsModule.class})
    @Event(handlers = AdminPresenter.class)
    public void addToMainPanel(Widget widget);

    @Start
    @Event(handlers = AdminPresenter.class)
    public void start();
}
