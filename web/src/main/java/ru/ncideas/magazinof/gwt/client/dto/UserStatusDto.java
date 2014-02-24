package ru.ncideas.magazinof.gwt.client.dto;

import java.io.Serializable;

public class UserStatusDto implements Serializable {

    Long id;

    String name;

    public UserStatusDto() {
    }

    public UserStatusDto(Long id, String name) {
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

        UserStatusDto userStatus = (UserStatusDto) o;

        if (!id.equals(userStatus.id)) return false;
        if (!name.equals(userStatus.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserStatusDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
