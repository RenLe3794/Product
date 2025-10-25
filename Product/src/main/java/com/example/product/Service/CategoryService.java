package com.example.product.Service;

import com.example.product.Dto.CategoryDto;
import com.example.product.Entity.CategoryEntity;
import com.example.product.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryDto saveCategory(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = categoryDto.convertEntity();
        categoryRepository.save(categoryEntity);
        return categoryDto;
    }
    public CategoryEntity updateCategory(Long id, CategoryEntity newData) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category không tồn tại"));
        category.setCategoryname(newData.getCategoryname());
        category.setDescription(newData.getDescription());
        return categoryRepository.save(category); // save sẽ ghi đè dữ liệu cũ
    }
    public Optional<CategoryEntity> findById(Long id){
        return categoryRepository.findById(id);
    }
    public void deleteById(Long Id) {
        categoryRepository.deleteById(Id);
    };

}
