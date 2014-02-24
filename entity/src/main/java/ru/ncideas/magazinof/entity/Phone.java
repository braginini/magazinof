package ru.ncideas.magazinof.entity;

public class Phone {

    Long id;

    String phone;

    public Phone() {
    }

    public Phone(Long id) {
        this.id = id;
    }

    public Phone(Long id, String phone) {
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

        Phone phone1 = (Phone) o;

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

