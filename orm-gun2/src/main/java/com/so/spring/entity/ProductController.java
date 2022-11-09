package com.so.spring.entity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/inventory")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product/insert")
    @ResponseBody
    public String insertProduct() {
        Product product = new Product(0, "Cep Telefonu", 160);
        productRepository.save(product);
        return "Eklendi: " + product.getId();
    }

    @GetMapping("/product/find")
    @ResponseBody
    public String findProduct() {
        long id = 1;
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            Product product = optional.get();
            return "Ürün: " + product.getProductName() + " " + product.getId();
        }
        return "Bulunamadı!";
    }


    @GetMapping("/products")
    @ResponseBody
    public Iterable<Product> listProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/delete")
    @ResponseBody
    public String deleteProduct() {
        long id = 3;
        if (!productRepository.existsById(id)) {
            return "Bulunamadı!";
        }
        productRepository.deleteById(id);
        return "Silindi: " + id;
    }

    @GetMapping("/products/expensive")
    @ResponseBody
    public Iterable<Product> listExpensiveProducts() {
        double minPrice = 157;
        return productRepository.findAllByPriceIsGreaterThan(minPrice);
    }
}
