package ru.ncideas.magazinof.gwt.client.dto;

import java.io.Serializable;

//created by m.bragin
public class PhoneDto implements Serializable{

    Long id;

    String phone;

    public PhoneDto() {
    }

    public PhoneDto(Long id) {
        this.id = id;
    }

    public PhoneDto(Long id, String phone) {
        this.id = id;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneDto phone1 = (PhoneDto) o;

        if (!id.equals(phone1.id)) return false;
        if (phone != null ? !phone.equals(phone1.phone) : phone1.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                '}';
    }
}
