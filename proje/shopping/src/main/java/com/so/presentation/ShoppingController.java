package com.so.presentation;

import com.so.business.dto.CartDto;
import com.so.business.dto.CartProductDto;
import com.so.business.service.CartProductService;
import com.so.business.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    private final CartService cartService;
    private final CartProductService cartProductService;

    public ShoppingController(CartService cartService, CartProductService cartProductService) {
        this.cartService = cartService;
        this.cartProductService = cartProductService;
    }

    @GetMapping("/cart/create")
    public ResponseEntity<?> createCart() {
        long cartId = cartService.create();
        return ResponseEntity.ok(cartId);
    }

    @PostMapping("/cart/add")
    public ResponseEntity<?> addToCart(@RequestBody CartProductDto cartProductDto) {
        cartProductService.add(cartProductDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cart/{cartId}/remove/{productId}")
    public ResponseEntity<?> removeFromCart(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
        cartProductService.remove(cartId, productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cart/checkout/{cartId}")
    public ResponseEntity<?> checkout(@PathVariable("cartId") long cartId) {
        cartService.checkout(cartId);
        return ResponseEntity.ok(cartId);
    }

    @GetMapping("/cart/find")
    public ResponseEntity<?> getCartById(@RequestParam long cartId) {
        CartDto cart = cartService.findCartById(cartId);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/cart/{cartId}/cartproducts")
    public ResponseEntity<?> getCartProductsByCartId(@PathVariable("cartId") long cartId) {
        List<CartProductDto> cartProducts = cartProductService.getCartProductsByCartId(cartId);
        return ResponseEntity.ok(cartProducts);
    }
}
