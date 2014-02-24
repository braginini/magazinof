package ru.ncideas.magazinof.gwt.client.dto;

import java.io.Serializable;
import java.util.Date;

public class OrderDto implements Serializable {

    private Long id;

    private String orderNumber;

    private Date orderDate;

    private Date deliveryDate;

    private String deliveryPeriod;

    private OrderStatusDto status;

    private OrganizationDto organization;

    private CustomerDto customer;

    private AddressDto address;

    private PhoneDto phone;

    private DeliveryTypeDto deliveryType;

    private UserDto employee;

    private UserDto courier;

    public OrderDto() {
    }

    public OrderDto(Long id, String orderNumber, Date orderDate, Date deliveryDate, String deliveryPeriod, OrderStatusDto status, OrganizationDto organization, CustomerDto customer, AddressDto address, PhoneDto phone, DeliveryTypeDto deliveryType, UserDto employee, UserDto courier) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.deliveryPeriod = deliveryPeriod;
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

    public OrderStatusDto getStatus() {
        return status;
    }

    public void setStatus(OrderStatusDto status) {
        this.status = status;
    }

    public OrganizationDto getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDto organization) {
        this.organization = organization;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public PhoneDto getPhone() {
        return phone;
    }

    public void setPhone(PhoneDto phone) {
        this.phone = phone;
    }

    public DeliveryTypeDto getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryTypeDto deliveryType) {
        this.deliveryType = deliveryType;
    }

    public UserDto getEmployee() {
        return employee;
    }

    public void setEmployee(UserDto employee) {
        this.employee = employee;
    }

    public String getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(String deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    public UserDto getCourier() {
        return courier;
    }

    public void setCourier(UserDto courier) {
        this.courier = courier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDto orderDto = (OrderDto) o;

        if (address != null ? !address.equals(orderDto.address) : orderDto.address != null) return false;
        if (courier != null ? !courier.equals(orderDto.courier) : orderDto.courier != null) return false;
        if (customer != null ? !customer.equals(orderDto.customer) : orderDto.customer != null) return false;
        if (deliveryDate != null ? !deliveryDate.equals(orderDto.deliveryDate) : orderDto.deliveryDate != null)
            return false;
        if (deliveryPeriod != null ? !deliveryPeriod.equals(orderDto.deliveryPeriod) : orderDto.deliveryPeriod != null)
            return false;
        if (deliveryType != null ? !deliveryType.equals(orderDto.deliveryType) : orderDto.deliveryType != null)
            return false;
        if (employee != null ? !employee.equals(orderDto.employee) : orderDto.employee != null) return false;
        if (!id.equals(orderDto.id)) return false;
        if (orderDate != null ? !orderDate.equals(orderDto.orderDate) : orderDto.orderDate != null) return false;
        if (orderNumber != null ? !orderNumber.equals(orderDto.orderNumber) : orderDto.orderNumber != null)
            return false;
        if (organization != null ? !organization.equals(orderDto.organization) : orderDto.organization != null)
            return false;
        if (phone != null ? !phone.equals(orderDto.phone) : orderDto.phone != null) return false;
        if (status != null ? !status.equals(orderDto.status) : orderDto.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
        result = 31 * result + (deliveryPeriod != null ? deliveryPeriod.hashCode() : 0);
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
        return "OrderDto{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", deliveryPeriod='" + deliveryPeriod + '\'' +
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
