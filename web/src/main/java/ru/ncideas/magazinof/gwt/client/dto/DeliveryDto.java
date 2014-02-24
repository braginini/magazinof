package ru.ncideas.magazinof.gwt.client.dto;

import ru.ncideas.magazinof.entity.DeliveryType;
import ru.ncideas.magazinof.entity.Order;

import java.io.Serializable;

/**
 * Author: Dmitry Naumov
 */
public class DeliveryDto implements Serializable {

    private Long id;

    private DeliveryTypeDto deliveryType;

    private OrderDto order;

    public DeliveryDto() {
    }

    public DeliveryDto(Long id) {
        this.id = id;
    }

    public DeliveryDto(Long id, DeliveryTypeDto deliveryType, OrderDto order) {
        this.id = id;
        this.deliveryType = deliveryType;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeliveryTypeDto getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryTypeDto deliveryType) {
        this.deliveryType = deliveryType;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryDto delivery = (DeliveryDto) o;

        if (deliveryType != null ? !deliveryType.equals(delivery.deliveryType) : delivery.deliveryType != null)
            return false;
        if (!id.equals(delivery.id)) return false;
        if (order != null ? !order.equals(delivery.order) : delivery.order != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (deliveryType != null ? deliveryType.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", deliveryType=" + deliveryType +
                ", order=" + order +
                '}';
    }
}
