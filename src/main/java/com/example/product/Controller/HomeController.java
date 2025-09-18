package com.example.product.Controller;

import com.example.product.Dto.ProductDto;
import com.example.product.Entity.ProductEntity;
import com.example.product.Service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;


@Controller
public class HomeController {
    @Autowired
    ProductService productService;
    @RequestMapping("")
    public String home( Model model)
    {
        model.addAttribute("prd2",new ProductDto());
        model.addAttribute("prd", productService.findAll());
        return "index";
    }
   @RequestMapping("/{key1}")
   public String search (@PathVariable (value = "key1",required = false) String key1 , Model model)
    {     // luôn có Product rỗng cho form create
        model.addAttribute("prd2",new ProductDto());
        // Nếu có từ khóa → tìm theo tên, không thì lấy tất cả
        if (key1 != null && !key1.isEmpty()) {
            model.addAttribute("prd", productService.findAllByName(key1));
        } else {
            model.addAttribute("prd", productService.findAll());
        }

        return "index";
    }

    @PostMapping(value = "create-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createUserForm(ProductDto productDto, RedirectAttributes redirectAttributes,
                                 HttpServletResponse response, HttpServletRequest request) throws SQLException {
        productService.saveProduct(productDto);
        redirectAttributes.addFlashAttribute("message", "Nhap san pham " + productDto.getName() + " thành công!");
        return "redirect:/index";
    }
    @RequestMapping(value = "/products/delete/{id}")
    public String deleteUser(@PathVariable(required = true,value = "id") Long id,Model model) throws SQLException {
        productService.deleteById(id);
        return "redirect:/";
    }
}
