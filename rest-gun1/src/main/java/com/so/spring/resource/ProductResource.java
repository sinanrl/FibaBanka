package com.so.spring.resource;

import com.so.spring.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductResource {

    @GetMapping("/api/products/{id}")
    public Product getProduct(@PathVariable("id") long productId) {
        return new Product(productId, "Sinan", 123);
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return List.of(
                new Product(1, "Sinan", 123),
                new Product(2, "Sinan1", 1234),
                new Product(3, "Sinan2", 12345));
    }

    @PostMapping("/api/products")
    public Product postProduct(@RequestBody Product product) {
        product.setProductId(311);
        System.out.println("Ürün eklendi: " + product.getProductName() + " " + product.getPrice());
        return product;
    }

    @PutMapping("/api/products")
    public void putProduct(@RequestBody Product product) {
        product.setProductId(311);
        System.out.println("Ürün güncellendi: " + product.getProductName() + " " + product.getPrice());
    }

    @DeleteMapping("/api/products/{id}")
    public long deleteProduct(@PathVariable("id") long productId) {
        System.out.println("Ürün silindi: " + productId);
        return productId;
    }
}
