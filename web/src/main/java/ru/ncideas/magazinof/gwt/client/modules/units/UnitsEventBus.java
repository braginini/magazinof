package ru.ncideas.magazinof.gwt.client.modules.units;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;

@Events(startView = UnitsView.class, module = UnitsModule.class)
public interface UnitsEventBus extends EventBus {

	@Event
	public void goToUnits();

	@Event( forwardToParent = true )
	public void changeCenterPanel(Widget viewWidget);

    @Start
	@Event
	public void start();
}
