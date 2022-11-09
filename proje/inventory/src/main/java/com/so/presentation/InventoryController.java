package com.so.presentation;

import com.so.business.dto.CategoryDto;
import com.so.business.dto.ProductDto;
import com.so.business.service.CategoryService;
import com.so.business.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public InventoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        List<CategoryDto> categories = categoryService.findAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductsByCategoryId(@PathVariable("id") long categoryId) {
        List<ProductDto> products = productService.findProductsByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") long productId) {
        ProductDto product = productService.findProductById(productId);
        if (product == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(product);
    }
}
