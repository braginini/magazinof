package ru.ncideas.magazinof.gwt.client.modules.sales.orders.pesenter;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomDateBox;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomListBox;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomTextBox;
import ru.ncideas.magazinof.gwt.client.dto.OrderDto;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseViewIntf;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.OrdersEventBus;
import ru.ncideas.magazinof.gwt.client.modules.sales.orders.view.OrdersDetailView;
import ru.ncideas.magazinof.gwt.client.services.RpcOrdersModuleServiceAsync;

import javax.inject.Inject;

//created by m.bragin
@Presenter(view = OrdersDetailView.class)
public class OrdersDetailPresenter extends BasePresenter<OrdersDetailPresenter.IOrdersDetailView, OrdersEventBus> {

    public interface IOrdersDetailView extends BaseViewIntf {

        public CustomTextBox getOrderNumber();

        public CustomDateBox getOrderDate();

        public CustomDateBox getDeliveryDate();

        public CustomTextBox getDeliveryPeriod();

        public CustomTextBox getOrderStatus();

        public CustomListBox getDeliveryType();

        public CustomTextBox getCourier();

        public CustomListBox getDeliveryFrom();

        public CustomTextBox getOrderCustomer();

        public Button getAddCustomerButton();

        public Button getAddAddressButton();

        public Button getChooseCustomerButton();

        public Button getChooseAddressButton();

        public CustomTextBox getOrderAddress();

    }

    @Inject
    RpcOrdersModuleServiceAsync service;

    private OrderDto orderDto;

    public void onStart() {
        //view.getViewWidget().setVisible(false);
        //eventBus.changeToolBarPanel(view.getViewWidget());
        view.getOrderNumber().setEnabled(false);
        view.getCourier().setEnabled(false);
    }

    public void onClickOrder(OrderDto orderDto) {
        eventBus.changeMainPanel(view.getViewWidget());
        //TODO искать в базе данные заказа  и заполнить ими форму заказа.
        //возможно два варианта 1) не искать весь заказ, а только данные о товарах по заказу, заполнить форму данными
        // из объекта OrderDto
        // при этом уменьшится нагрузка на бд и время отклика, но данные могли обновится в БД будут устаревшие.
        // 2) искать данные о заказе в бд снова дабы избежать неактуальных данных, при этом нагрузка на БД,
        // но можео использовать encache
        //3) реализовать gwteventservice и тогда тогда клиент сможет слушать изменения на сервере и можно будет
        //воспользоваться первым вариантом
        // вариант 3 предпочтительней
        disableFrom();
        service.findOrderById(orderDto.getId(), new AsyncCallback<OrderDto>() {
            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(OrderDto result) {
                fillForm(result);
            }
        });

    }

    private void disableFrom() {
    }

    private void fillForm(OrderDto orderDto) {
        this.orderDto = orderDto;
        view.getOrderNumber().setValue(orderDto.getOrderNumber().toString());
        view.getOrderDate().setValue(orderDto.getOrderDate());
        view.getDeliveryDate().setValue(orderDto.getDeliveryDate());
        view.getDeliveryPeriod().setValue(orderDto.getDeliveryPeriod());
        view.getOrderCustomer().setValue(orderDto.getCustomer().getFirstName() + " " + orderDto.getCustomer().getLastName());
        view.getOrderAddress().setValue(orderDto.getAddress().getAddress());
        view.getOrderStatus().setValue(orderDto.getStatus().getName());
        //TODO change the style to add item
        //TODO commented fields
        //view.getDeliveryType().setValue(0, orderDto.getDeliveryType().getName());
       // view.getCourier().setValue(orderDto.getCourier().getFirst_name() + " " + orderDto.getCourier().getLast_name());
        //TODO DeliveryFrom field
    }
}
