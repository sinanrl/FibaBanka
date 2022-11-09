package com.so.business.service;

import com.so.business.dto.CartProductDto;

import java.util.List;

public interface CartProductService {
    void add(CartProductDto cartProductDto);
    void remove(long cartId, long cartProductId);

    List<CartProductDto> getCartProductsByCartId(long cartId);
}
