package ru.ncideas.magazinof.gwt.client.modules.warehouses;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;

@Events(startView = WarehousesView.class, module = WarehousesModule.class)
public interface WarehousesEventBus extends EventBus {

	@Event
	public void goToWarehouses();

	@Event( forwardToParent = true )
	public void changeCenterPanel(Widget viewWidget);

    @Start
	@Event
	public void start();
}
