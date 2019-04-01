package com.mockingserv.cashmanagerserv.cashmanagerdataserv.models;

import com.mockingserv.cashmanagerserv.cashmanagerdataserv.DTOs.CategoryDTO;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.IFACE.ApiObject;

import javax.persistence.*;


@Entity
@Table(name = "category_")
public class Category extends AuditModel implements ApiObject<CategoryDTO> {

    @Id
    @GeneratedValue(generator = "category_generator")
    @SequenceGenerator(
            name = "category_generator",
            sequenceName = "catogery_sequence",
            initialValue = 1000
    )
    @Column(name = "id_category",updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    public Category(String name) {
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

    public CategoryDTO toDTO() {
        return new CategoryDTO( this.id, this.name);

    }
    public Category() {
    }


    public boolean equalCatégory(Category category) {
        if (category.name.equalsIgnoreCase(this.name.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
}
