package ru.ncideas.magazinof.entity;

import java.util.Date;
import java.util.List;

public class Order {

    private Long id;

    private String orderNumber;

    private String deliveryPeriod;

    private Date orderDate;

    private Date deliveryDate;

    private OrderStatus status;

    private Organization organization;

    private Customer customer;

    private Address address;

    private Phone phone;

    private DeliveryType deliveryType;

    private User employee;

    private User courier;

    public Order() {
    }

    public Order(Long id, String orderNumber, String deliveryPeriod, Date orderDate, Date deliveryDate, OrderStatus status, Organization organization, Customer customer, Address address, Phone phone, DeliveryType deliveryType, User employee, User courier) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.deliveryPeriod = deliveryPeriod;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.organization = organization;
        this.customer = customer;
        this.address = address;
        this.phone = phone;
        this.deliveryType = deliveryType;
        this.employee = employee;
        this.courier = courier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(String deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public User getCourier() {
        return courier;
    }

    public void setCourier(User courier) {
        this.courier = courier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (address != null ? !address.equals(order.address) : order.address != null) return false;
        if (courier != null ? !courier.equals(order.courier) : order.courier != null) return false;
        if (customer != null ? !customer.equals(order.customer) : order.customer != null) return false;
        if (deliveryDate != null ? !deliveryDate.equals(order.deliveryDate) : order.deliveryDate != null) return false;
        if (deliveryPeriod != null ? !deliveryPeriod.equals(order.deliveryPeriod) : order.deliveryPeriod != null)
            return false;
        if (deliveryType != null ? !deliveryType.equals(order.deliveryType) : order.deliveryType != null) return false;
        if (employee != null ? !employee.equals(order.employee) : order.employee != null) return false;
        if (!id.equals(order.id)) return false;
        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;
        if (orderNumber != null ? !orderNumber.equals(order.orderNumber) : order.orderNumber != null) return false;
        if (organization != null ? !organization.equals(order.organization) : order.organization != null) return false;
        if (phone != null ? !phone.equals(order.phone) : order.phone != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
        result = 31 * result + (deliveryPeriod != null ? deliveryPeriod.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (deliveryType != null ? deliveryType.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + (courier != null ? courier.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", deliveryPeriod='" + deliveryPeriod + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", status=" + status +
                ", organization=" + organization +
                ", customer=" + customer +
                ", address=" + address +
                ", phone=" + phone +
                ", deliveryType=" + deliveryType +
                ", employee=" + employee +
                ", courier=" + courier +
                '}';
    }
}
