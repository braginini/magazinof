package ru.ncideas.magazinof.gwt.client.modules.home;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;

@Events(startView = HomeView.class, module = HomeModule.class)
public interface HomeEventBus extends EventBus {

	@Event
	public void goToHome();

	@Event( forwardToParent = true )
	public void changeCenterPanel(Widget widget);

    @Start
	@Event
	public void start();
}
