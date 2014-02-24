package ru.ncideas.magazinof.gwt.client.dto;

import java.io.Serializable;

//created by m.bragin
public class AddressDto implements Serializable {

    Long id;

    String address;

    public AddressDto() {
    }

    public AddressDto(Long id) {
        this.id = id;
    }

    public AddressDto(Long id, String address) {
        this.address = address;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressDto address1 = (AddressDto) o;

        if (address != null ? !address.equals(address1.address) : address1.address != null) return false;
        if (!id.equals(address1.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
