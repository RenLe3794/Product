package com.example.product.Dto;
import com.example.product.Entity.CategoryEntity;
import com.example.product.Entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductDto {
    Long id;
    public String name;
    public String description;
    public double price;
    public int quantity;
    public Long categoryid  ;
    public CategoryEntity category;
    public ProductEntity convertEntity() {
        ProductEntity entity = new ProductEntity();
        entity.setName(this.name);
        entity.setDescription(this.description);
        entity.setPrice(this.price);
        entity.setQuantity(this.quantity);
        entity.setCategoryid(this.categoryid);
        return entity;
    }

    public Long getId(Long id) {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public Long getId() {
        return id;
    }

    public Long getCategoryid() {

        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public void setCategory(Long cateId) {
        this.categoryid = cateId;
    }

}