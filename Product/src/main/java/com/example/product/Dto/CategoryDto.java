package com.example.product.Dto;

import com.example.product.Entity.CategoryEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    public Long id;
    public String Name;
    public String Description;
    public CategoryEntity convertEntity(){
        CategoryEntity categoryEntity =new CategoryEntity();
        categoryEntity.setId(this.id);
        categoryEntity.setCategoryname(this.Name);
        categoryEntity.setDescription(this.Description);
        return categoryEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

}
