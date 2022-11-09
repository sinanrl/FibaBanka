package com.so.presentation;

import com.so.business.dto.CartDto;
import com.so.business.dto.CartProductDto;
import com.so.business.dto.CategoryDto;
import com.so.business.dto.ProductDto;
import com.so.business.service.CommerceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commerce")
public class CommerceController {

    private final CommerceService commerceService;

    public CommerceController(CommerceService commerceService) {
        this.commerceService = commerceService;
    }

    @GetMapping("/inventory/categories")
    public ResponseEntity<?> getAllCategories() {
        List<CategoryDto> categories = commerceService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/inventory/products/{categoryId}")
    public ResponseEntity<?> getAllProductsByCategoryId(@PathVariable("categoryId") long categoryId) {
        List<ProductDto> products = commerceService.getProductsByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/inventory/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") long id) {
        ProductDto product = commerceService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/shopping/cart/create")
    public ResponseEntity<?> createCart() {
        long cartId = commerceService.createCart();
        return ResponseEntity.ok(cartId);
    }

    @PostMapping("/shopping/cart/add")
    public ResponseEntity<?> addToCart(@RequestBody CartProductDto cartProductDto) {
        commerceService.addToCart(cartProductDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/shopping/cart/{cartId}/remove/{productId}")
    public ResponseEntity<?> removeFromCart(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
        commerceService.removeFromCart(cartId, productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/shopping/checkout/{cartId}")
    public ResponseEntity<?> checkout(@PathVariable("cartId") long cartId) {
        long cart = commerceService.checkout(cartId);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/shopping/cart/find")
    public ResponseEntity<?> getCartById(@RequestParam long cartId) {
        CartDto cart = commerceService.getCartById(cartId);
        return ResponseEntity.ok(cart);
    }
}
