package ru.ncideas.magazinof.entity;

/**
 * @author mbragin
 */
public class DeliveryType {

    private Long id;

    private String name;

    public DeliveryType() {
    }

    public DeliveryType(Long id) {
        this.id = id;
    }

    public DeliveryType(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryType that = (DeliveryType) o;

        if (!id.equals(that.id)) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeliveryType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
