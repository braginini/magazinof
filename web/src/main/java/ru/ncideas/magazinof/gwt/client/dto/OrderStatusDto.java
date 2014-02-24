package ru.ncideas.magazinof.gwt.client.dto;

import java.io.Serializable;

//created by m.bragin
public class OrderStatusDto implements Serializable {

    private Long id;

    private String name;

    private String description;

    private OrganizationDto organization;

    public OrderStatusDto() {
    }

    public OrderStatusDto(Long id) {
        this.id = id;
    }

    public OrderStatusDto(Long id, String name, String description, OrganizationDto organization) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrganizationDto getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDto organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderStatusDto that = (OrderStatusDto) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (!id.equals(that.id)) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", organization=" + organization +
                '}';
    }
}
