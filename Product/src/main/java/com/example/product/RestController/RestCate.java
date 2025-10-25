package com.example.product.RestController;

import com.example.product.Dto.CategoryDto;
import com.example.product.Entity.CategoryEntity;
import com.example.product.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RestCate {
    @Autowired
    CategoryService categoryService;

    @GetMapping("api/categories")
    public List<CategoryEntity> getAll(){
        return categoryService.findAll();
    }

    @PostMapping("api/categories")
    public void create(@RequestParam(required = true,value = "name")String name,
                       @RequestParam(required = true,value = "des")String des,
                        CategoryDto categoryDto)
    {
        categoryDto.setName(name);
        categoryDto.setDescription(des);
        categoryService.saveCategory(categoryDto);
    }
    @PutMapping("api/categories/{id}")
    public void edit(@RequestParam(required = true,value = "name")String name,
                       @RequestParam(required = true,value = "des")String des,
                       @PathVariable(required = true, value ="id") Long id,
                        CategoryEntity categoryEntity)
    {

        categoryEntity.setCategoryname(name);
        categoryEntity.setDescription(des);
        categoryService.updateCategory(id,categoryEntity);

    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable(required = true,value = "id") Long id){

        categoryService.deleteById(id);

    }
}
