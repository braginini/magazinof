package ru.ncideas.magazinof.gwt.client.dto;

import java.io.Serializable;

public class GoodDto implements Serializable {

    private Long id;

    private String name;

    private String description;

    private String article;

    private Long measureId;

    private Long organizationId;

    private Long accountId;

    private MeasureDto measure;

    public GoodDto() {
    }

    public GoodDto(Long id) {
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

    public MeasureDto getMeasure() {
        return measure;
    }

    public void setMeasure(MeasureDto measure) {
        this.measure = measure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodDto goodDto = (GoodDto) o;

        if (accountId != null ? !accountId.equals(goodDto.accountId) : goodDto.accountId != null) return false;
        if (article != null ? !article.equals(goodDto.article) : goodDto.article != null) return false;
        if (description != null ? !description.equals(goodDto.description) : goodDto.description != null) return false;
        if (id != null ? !id.equals(goodDto.id) : goodDto.id != null) return false;
        if (measureId != null ? !measureId.equals(goodDto.measureId) : goodDto.measureId != null) return false;
        if (name != null ? !name.equals(goodDto.name) : goodDto.name != null) return false;
        if (organizationId != null ? !organizationId.equals(goodDto.organizationId) : goodDto.organizationId != null)
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
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GoodDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", article='" + article + '\'' +
                ", measureId=" + measureId +
                ", organizationId=" + organizationId +
                ", accountId=" + accountId +
                '}';
    }
}
