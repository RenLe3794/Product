package com.example.product.Service;

import com.example.product.Dto.ProductDto;
import com.example.product.Entity.ProductEntity;
import com.example.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
    public List<ProductEntity> findAllByName(String k) {
        return productRepository.findAllByName(k);
    }
    public ProductDto saveProduct(ProductDto productDto) {
        ProductEntity productEntity = productDto.convertEntity();
        productRepository.save(productEntity);
        return productDto;
    }
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    };

}
