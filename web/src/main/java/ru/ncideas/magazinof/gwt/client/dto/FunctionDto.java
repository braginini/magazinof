package ru.ncideas.magazinof.gwt.client.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class FunctionDto implements Serializable {

    private static final long serialVersionUID = 3172573772735927705L;

    Long id;

    String name;

    public FunctionDto() {
    }

    public FunctionDto(Long id) {
        this.id = id;
    }

    public FunctionDto(Long id, String name) {
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

        FunctionDto function = (FunctionDto) o;

        if (!id.equals(function.id)) return false;
        if (name != null ? !name.equals(function.name) : function.name != null) return false;

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
        return "Function{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

