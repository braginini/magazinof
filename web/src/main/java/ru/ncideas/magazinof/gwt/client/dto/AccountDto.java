package ru.ncideas.magazinof.gwt.client.dto;

import java.io.Serializable;

public class AccountDto implements Serializable {

    Long id;

    String name;

    public AccountDto() {
    }

    public AccountDto(Long id) {
        this.id = id;
    }

    public AccountDto(java.lang.Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
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

        AccountDto account = (AccountDto) o;

        if (!id.equals(account.id)) return false;
        if (name != null ? !name.equals(account.name) : account.name != null) return false;

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
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
