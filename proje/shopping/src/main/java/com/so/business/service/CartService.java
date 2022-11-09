package com.so.business.service;

import com.so.business.dto.CartDto;
import com.so.business.dto.CartProductDto;

public interface CartService {
    long create();
    void checkout(long cartId);
    CartDto findCartById(long id);
}
