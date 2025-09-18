package com.example.product.RestController;

import com.example.product.Dto.ProductDto;
import com.example.product.Entity.ProductEntity;
import com.example.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class RestProduct {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<ProductEntity> getAllProduct() {
        return productService.findAll();
    }

    @GetMapping("/getbyName/{name}")
    public List<ProductEntity> getAllProduct(@PathVariable(required = true,value = "name") String name) {
        return productService.findAllByName(name);
    }

    @PutMapping("/edit/{id}")
    public void edit(@RequestParam(required = true,value = "name")String name,@RequestParam(required = true,value = "des")String des,
                     @RequestParam(required = true,value = "price")double price,@PathVariable(required = true,value = "id") Long id,@RequestParam(required = true,value = "quantity")String quantity){
        ProductDto productDto = new ProductDto();
        productDto.setName(name);
        productDto.setDescription(des);
        productDto.setPrice(price);
        productDto.setQuantity(Integer.parseInt(quantity));
        productService.saveProduct(productDto);

    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable(required = true,value = "id") Long id){

         productService.deleteById(id);

    }

}

