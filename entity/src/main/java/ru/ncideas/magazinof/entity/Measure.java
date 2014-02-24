package ru.ncideas.magazinof.entity;

/**
 * User: mbragin
 * Date: 07.06.12
 * Time: 17:18
 */
public class Measure {

    private Long id;

    private String name;

    private Long accountId;

    public Measure() {
    }

    public Measure(Long id, String name, Long accountId) {
        this.id = id;
        this.name = name;
        this.accountId = accountId;
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

        Measure measure = (Measure) o;

        if (accountId != null ? !accountId.equals(measure.accountId) : measure.accountId != null) return false;
        if (id != null ? !id.equals(measure.id) : measure.id != null) return false;
        if (name != null ? !name.equals(measure.name) : measure.name != null) return false;

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
        return "Measure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
