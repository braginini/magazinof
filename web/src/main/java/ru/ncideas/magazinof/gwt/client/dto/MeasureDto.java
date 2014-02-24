package ru.ncideas.magazinof.gwt.client.dto;

import java.io.Serializable;

/**
 * User: mbragin
 * Date: 07.06.12
 * Time: 17:16
 */
public class MeasureDto implements Serializable {

    private Long id;

    private String name;

    private Long accountId;

    public MeasureDto() {

    }

    public MeasureDto(String name, Long accountId, Long id) {
        this.name = name;
        this.accountId = accountId;
        this.id = id;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasureDto that = (MeasureDto) o;

        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MeasureDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
