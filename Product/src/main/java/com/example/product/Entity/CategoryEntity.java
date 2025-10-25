package com.example.product.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "category", schema = "product", catalog = "")
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "categoryid", nullable = false)
    private Long id;
    @Basic
    @Column(name = "categoryname", nullable = false, length = 100)
    private String categoryname;
    @Basic
    @Column(name = "descriptionn", nullable = true, length = 255)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryname() {
        return categoryname;
    }

}
