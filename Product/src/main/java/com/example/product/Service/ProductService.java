package com.example.product.Service;

import com.example.product.Dto.ProductDto;
import com.example.product.Entity.ProductEntity;
import com.example.product.Repository.CategoryRepository;
import com.example.product.Repository.ProductRepository;
import com.example.product.paging.PagingAndSortObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
    public Page<ProductEntity> findAllByName2(String k,PagingAndSortObject paging) {
        return (Page<ProductEntity>) productRepository.findAllByName2(k,(Pageable)paging.toPageable());
    }
    public List<ProductEntity> findAllByName(String k){
        return (List<ProductEntity>) productRepository.findAllByName(k);
    }
    public ProductDto saveProduct(ProductDto productDto) {
        ProductEntity productEntity = productDto.convertEntity();
        productRepository.save(productEntity);
        return productDto;
    }

    public Page<ProductEntity> list(PagingAndSortObject paging) {
        return productRepository.findAll((Pageable) paging.toPageable());
    }
    public Page<ProductEntity> listBycate(Long id,PagingAndSortObject paging){
        return (Page<ProductEntity>) productRepository.findAllByCategoryId(id,(Pageable)paging.toPageable());
    }
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    };
//    public ProductDto getProductById(Long id) {
//        return (ProductDto) productRepository.findAllByCategoryId(id);
//    }

}
