package ru.ncideas.magazinof.entity;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Good {

    private Long id;

    private String name;

    private String description;

    private String article;

    private Long measureId;

    private Long accountId ;

    private Long organizationId ;

    private Measure measure;

    public Good() {
    }

    public Good(Long id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Long getMeasureId() {
        return measureId;
    }

    public void setMeasureId(Long measureId) {
        this.measureId = measureId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Measure getMeasure() {
        HashSet set = new HashSet();

        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (accountId != null ? !accountId.equals(good.accountId) : good.accountId != null) return false;
        if (article != null ? !article.equals(good.article) : good.article != null) return false;
        if (description != null ? !description.equals(good.description) : good.description != null) return false;
        if (id != null ? !id.equals(good.id) : good.id != null) return false;
        if (measureId != null ? !measureId.equals(good.measureId) : good.measureId != null) return false;
        if (name != null ? !name.equals(good.name) : good.name != null) return false;
        if (organizationId != null ? !organizationId.equals(good.organizationId) : good.organizationId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);
        result = 31 * result + (measureId != null ? measureId.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", article='" + article + '\'' +
                ", measureId=" + measureId +
                ", accountId=" + accountId +
                ", organizationId=" + organizationId +
                '}';
    }
}
