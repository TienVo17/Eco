package com.tienvo17.controllers.admin;

import com.tienvo17.models.Category;
import com.tienvo17.models.Product;
import com.tienvo17.services.CategoryService;
import com.tienvo17.services.ProductService;
import com.tienvo17.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private ProductService productService;
    @RequestMapping("/product")
    public String index(Model model) {
        List<Product> listProduct = productService.getAll();
        model.addAttribute("listProduct",listProduct);
        return "admin/product/index";
    }
    @RequestMapping("/product-add")
    public String add(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        List<Category> listCate= categoryService.getAll();
        model.addAttribute("listCate",listCate);
        return "admin/product/add";
    }
    @PostMapping("/product-add")
    public String save(@ModelAttribute("product") Product product,@RequestParam("fileImage") MultipartFile file){
        this.storageService.store(file);
        String fileName = file.getOriginalFilename();
        product.setImage(fileName);
        if (this.productService.create(product))
        {
            return "redirect:/admin/product";
        }
        return "admin/product/add";
    }
}
