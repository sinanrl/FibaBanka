package com.so.business.service;

import com.so.business.dto.CategoryDto;
import com.so.business.dto.ProductDto;

import java.util.List;

public interface InventoryService {
    List<CategoryDto> getAllCategories();
    List<ProductDto> getProductsByCategoryId(long categoryId);
    ProductDto getProductById(long productId);
}
