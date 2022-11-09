package com.so.business.service;

import com.so.business.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findProductsByCategoryId(long categoryId);
    ProductDto findProductById(long productId);
}
