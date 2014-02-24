package ru.ncideas.magazinof.entity;

/**
 * Author: Dmitry Naumov
 */
public class Delivery {

    private Long id;

    private DeliveryType deliveryType;

    private Order order;

    public Delivery() {
    }

    public Delivery(Long id) {
        this.id = id;
    }

    public Delivery(Long id, DeliveryType deliveryType, Order order) {
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

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Delivery delivery = (Delivery) o;

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
