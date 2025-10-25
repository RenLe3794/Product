package com.example.product.Controller;

import com.example.product.Dto.CategoryDto;
import com.example.product.Dto.ProductDto;
import com.example.product.Entity.ProductEntity;
import com.example.product.Service.CategoryService;
import com.example.product.Service.ProductService;
import com.example.product.paging.PagingAndSortObject;
import com.example.product.paging.PagingAndSortParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @Autowired
    CategoryService categoryService;
    @RequestMapping({"/","/index","/home","/product"})
    public String home(@RequestParam(required = false) Long id,
                       @PagingAndSortParam(path ="product") PagingAndSortObject paging, Model model
                        , RedirectAttributes redirectAttributes) throws SQLException
    {
        Page<ProductEntity> page;
        model.addAttribute("cate2",new CategoryDto());
        model.addAttribute("cate",categoryService.findAll());
        model.addAttribute("prd2",new ProductDto());
        if (id == null ||id == 0) page =  productService.list(paging);
        else  page = productService.listBycate((id),paging);
        model.addAttribute("prd",page.getContent() );
        model.addAttribute("currentPage", paging.getPage());
        int totalPages = page.getTotalPages();
        if (totalPages == 0) totalPages = 1;
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("sortField", paging.getSortField());
        model.addAttribute("sortDir", paging.getSortDir());
        model.addAttribute("reverseSortDir", paging.getSortDir().equals("asc") ? "desc" : "asc");

        return "index";
    }

   @RequestMapping("index/search")
   public String search (@RequestParam (value = "key1",required = false) String key1 , Model model,@PagingAndSortParam(path ="product") PagingAndSortObject paging)
    {   model.addAttribute("cate2",new CategoryDto());
        model.addAttribute("cate",categoryService.findAll());
        model.addAttribute("prd2",new ProductDto());
        Page<ProductEntity> page = productService.findAllByName2(key1,paging);
        model.addAttribute("prd",page.getContent() );
        model.addAttribute("currentPage", paging.getPage());
        int totalPages = page.getTotalPages();
        if (totalPages == 0) totalPages = 1;
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("sortField", paging.getSortField());
        model.addAttribute("sortDir", paging.getSortDir());
        model.addAttribute("reverseSortDir", paging.getSortDir().equals("asc") ? "desc" : "asc");
        return "index";
    }

    @PostMapping(value = "create-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createForm1(ProductDto productDto, RedirectAttributes redirectAttributes,
                                 HttpServletResponse response, HttpServletRequest request) throws SQLException {
        System.out.println("Giá nhận được: " + productDto.getPrice());
        productService.saveProduct(productDto);
        redirectAttributes.addFlashAttribute("message", "Nhap san pham " + productDto.getName() + " thành công!");
        return "redirect:index";
    }
    @PostMapping(value = "create-form2", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createForm2(CategoryDto categoryDto, RedirectAttributes redirectAttributes,
                                 HttpServletResponse response, HttpServletRequest request) throws SQLException {
        categoryService.saveCategory(categoryDto);
        redirectAttributes.addFlashAttribute("message", "Nhap the loai " + categoryDto.getName() + " thành công!");
        return "redirect:index";
    }



    @RequestMapping(value = "product/delete/{id}")
    public String deleteUser(@PathVariable(required = true,value = "id") Long id,Model model) throws SQLException {
        productService.deleteById(id);
        return "redirect:/index";
    }

}
