package com.so.business.service;

import com.so.business.dto.CartDto;
import com.so.business.dto.CartProductDto;

public interface ShoppingService {
    long createCart();
    void addToCart(CartProductDto cartProductDto);
    void removeFromCart(long cartId, long productId);
    long checkout(long cartId);
    CartDto getCartById(long cartId);
}
