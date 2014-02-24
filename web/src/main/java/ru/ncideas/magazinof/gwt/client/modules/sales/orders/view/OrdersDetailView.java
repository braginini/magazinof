package ru.ncideas.magazinof.gwt.client.modules.sales.orders.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import ru.ncideas.magazinof.gwt.client.Messages;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomDateBox;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomListBox;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomTextBox;
import ru.ncideas.magazinof.gwt.client.components.forms.ContentPanel;
import ru.ncideas.magazinof.gwt.client.components.forms.Orientation;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.pesenter.OrdersDetailPresenter;

public class OrdersDetailView extends Composite implements OrdersDetailPresenter.IOrdersDetailView {

    private static final Messages messages = GWT.create(Messages.class);

    private DockLayoutPanel body = new DockLayoutPanel(Style.Unit.PX);
    private CustomTextBox orderNumber = new CustomTextBox();
    private CustomDateBox orderDate = new CustomDateBox();
    private CustomDateBox deliveryDate = new CustomDateBox();
    private CustomTextBox deliveryPeriod = new CustomTextBox();
    private CustomTextBox orderStatus = new CustomTextBox();
    private CustomListBox deliveryType = new CustomListBox();
    private CustomTextBox courier = new CustomTextBox();
    private CustomListBox deliveryFrom = new CustomListBox();
    private CustomTextBox orderCustomer = new CustomTextBox();

    private CustomTextBox orderAddress = new CustomTextBox();

    private Button addCustomerButton = new Button(messages.Common_Add());
    private Button addAddressButton = new Button(messages.Common_Add());
    private Button chooseCustomerButton = new Button(messages.Common_Choose());
    private Button chooseAddressButton = new Button(messages.Common_Choose());

    public OrdersDetailView() {
        body.setSize("100%", "100%");
        body.add(initTabPanel());
        initWidget(body);
    }

    private Widget initTabPanel() {
        TabLayoutPanel tabLayoutPanel = new TabLayoutPanel(34, Style.Unit.PX);
        tabLayoutPanel.add(initOrderBasicInfo(), "Basic");
        tabLayoutPanel.add(initDeliveryInfo(), "Delivery");
        tabLayoutPanel.add(initOrderExtraInfo(), "Extra");
        return tabLayoutPanel;
    }

    private Widget initDeliveryInfo() {
        //init 3 panels oriented vertically
        ContentPanel panel = new ContentPanel(Orientation.VERTICAL);

        ContentPanel firstPanel = new ContentPanel(Orientation.HORIZONTAL);
        ContentPanel secondPanel = new ContentPanel(Orientation.HORIZONTAL);
        ContentPanel thirdPanel = new ContentPanel(Orientation.HORIZONTAL);   //todo maybe put map on third panel ?

        deliveryDate.setFieldLabel(messages.OrdersDetailView_orderDeliveryDate());
        deliveryDate.setContentBoxStyle("mf-contentbox");

        deliveryType.setFieldLabel(messages.OrdersDetailView_orderDeliveryType());
        deliveryType.setContentBoxStyle("mf-contentbox");

        deliveryPeriod.setFieldLabel(messages.OrdersDetailView_orderDeliveryTimePeriod());
        deliveryPeriod.setContentBoxStyle("mf-contentbox");

        deliveryFrom.setFieldLabel(messages.OrdersDetailView_orderDeliveryFrom());
        deliveryFrom.setContentBoxStyle("mf-contentbox");

        courier.setFieldLabel(messages.OrdersDetailView_orderDeliveryCourier());
        courier.setContentBoxStyle("mf-contentbox-wide");

        firstPanel.add(deliveryDate);
        firstPanel.add(deliveryPeriod);
        firstPanel.add(deliveryType);
        firstPanel.add(deliveryFrom);

        secondPanel.add(courier);

        panel.add(firstPanel);
        panel.add(secondPanel);

        return panel;
    }

    private Widget initOrderExtraInfo() {
        return new ContentPanel();
    }

    private Widget initOrderBasicInfo() {

        ContentPanel mainPanel = new ContentPanel(Orientation.VERTICAL);

        ContentPanel firstPanel = new ContentPanel(Orientation.HORIZONTAL);
        ContentPanel secondPanel = new ContentPanel(Orientation.HORIZONTAL);
        ContentPanel thirdPanel = new ContentPanel(Orientation.HORIZONTAL);

        orderNumber.setContentBoxStyle("mf-contentbox");
        orderNumber.setFieldLabel(messages.OrdersDetailView_orderNumberLabel());

        orderStatus.setContentBoxStyle("mf-contentbox");
        orderStatus.setFieldLabel(messages.OrdersDetailView_status());

        orderDate.setContentBoxStyle("mf-contentbox");
        orderDate.setFieldLabel(messages.OrdersDetailView_orderDate());

        firstPanel.add(orderNumber);
        firstPanel.add(orderStatus);
        firstPanel.add(orderDate);

        orderCustomer.setFieldLabel(messages.OrdersDetailView_orderCustomer());
        orderCustomer.setContentBoxStyle("mf-contentbox-wide");

        orderAddress.setFieldLabel(messages.OrdersDetailView_address());
        orderAddress.setContentBoxStyle("mf-contentbox-wide");

        secondPanel.add(orderCustomer);
        secondPanel.add(orderAddress);

        //TODO prepare and add products lines  and place on thirdPanel
        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);

        return mainPanel;
    }

    public CustomTextBox getOrderNumber() {
        return orderNumber;
    }

    public CustomDateBox getOrderDate() {
        return orderDate;
    }

    public CustomDateBox getDeliveryDate() {
        return deliveryDate;
    }

    public CustomTextBox getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public CustomTextBox getOrderStatus() {
        return orderStatus;
    }

    public CustomListBox getDeliveryType() {
        return deliveryType;
    }

    public CustomTextBox getCourier() {
        return courier;
    }

    public CustomListBox getDeliveryFrom() {
        return deliveryFrom;
    }

    public Button getAddCustomerButton() {
        return addCustomerButton;
    }

    public Button getAddAddressButton() {
        return addAddressButton;
    }

    public Button getChooseCustomerButton() {
        return chooseCustomerButton;
    }

    public Button getChooseAddressButton() {
        return chooseAddressButton;
    }

    public CustomTextBox getOrderCustomer() {
        return orderCustomer;
    }

    public void setOrderCustomer(CustomTextBox orderCustomer) {
        this.orderCustomer = orderCustomer;
    }

    public CustomTextBox getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(CustomTextBox orderAddress) {
        this.orderAddress = orderAddress;
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }
}
