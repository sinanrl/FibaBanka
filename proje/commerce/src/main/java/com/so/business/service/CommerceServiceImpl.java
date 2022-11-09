package com.so.business.service;

import com.so.business.dto.CartDto;
import com.so.business.dto.CartProductDto;
import com.so.business.dto.CategoryDto;
import com.so.business.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommerceServiceImpl implements CommerceService {

    private final InventoryService inventoryService;
    private final ShoppingService shoppingService;

    public CommerceServiceImpl(InventoryService inventoryService, ShoppingService shoppingService) {
        this.inventoryService = inventoryService;
        this.shoppingService = shoppingService;
    }

    @Override
    public long createCart() {
        return shoppingService.createCart();
    }

    @Override
    public void addToCart(CartProductDto cartProductDto) {
        shoppingService.addToCart(cartProductDto);
    }

    @Override
    public void removeFromCart(long cartId, long productId) {
        shoppingService.removeFromCart(cartId, productId);
    }

    @Override
    public long checkout(long cartId) {
        shoppingService.checkout(cartId);
        return cartId;
    }

    @Override
    public CartDto getCartById(long cartId) {
        CartDto cart = shoppingService.getCartById(cartId);
        for (int i = 0; i < cart.getCartProducts().size(); i++) {
            ProductDto product = inventoryService.getProductById(cart.getCartProducts().get(i).getProductId());
            cart.getCartProducts().get(i).setProductName(product.getProductName());
        }

        return cart;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return inventoryService.getAllCategories();
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(long categoryId) {
        return inventoryService.getProductsByCategoryId(categoryId);
    }

    @Override
    public ProductDto getProductById(long productId) {
        return inventoryService.getProductById(productId);
    }
}
