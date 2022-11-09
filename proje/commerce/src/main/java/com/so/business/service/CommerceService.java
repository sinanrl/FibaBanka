package com.so.business.service;

import com.so.business.dto.CartDto;
import com.so.business.dto.CartProductDto;
import com.so.business.dto.CategoryDto;
import com.so.business.dto.ProductDto;

import java.util.List;

public interface CommerceService {
    long createCart();
    void addToCart(CartProductDto cartProductDto);
    void removeFromCart(long cartId, long productId);
    long checkout(long cartId);
    CartDto getCartById(long cartId);
    List<CategoryDto> getAllCategories();
    List<ProductDto> getProductsByCategoryId(long categoryId);
    ProductDto getProductById(long productId);
}
