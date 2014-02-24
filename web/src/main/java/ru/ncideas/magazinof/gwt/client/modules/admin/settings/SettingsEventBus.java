package ru.ncideas.magazinof.gwt.client.modules.admin.settings;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;
import ru.ncideas.magazinof.gwt.client.modules.admin.settings.presenter.SettingsPresenter;
import ru.ncideas.magazinof.gwt.client.modules.admin.settings.view.SettingsView;

@Events(startView = SettingsView.class, module = SettingsModule.class)
public interface SettingsEventBus extends EventBus {

    @Event
	public void goToSettings();

    @Start
    @Event(handlers = SettingsPresenter.class )
	public void start();

}
