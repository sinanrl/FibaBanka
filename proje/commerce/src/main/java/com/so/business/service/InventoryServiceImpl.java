package com.so.business.service;

import com.so.business.dto.CategoryDto;
import com.so.business.dto.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class InventoryServiceImpl implements InventoryService{

    @Value("${inventoryservice.url}")
    private String inventoryServiceUrl;

    @Override
    public List<CategoryDto> getAllCategories() {
        String url = inventoryServiceUrl + "/categories";
        RestTemplate restTemplate = new RestTemplate();
        CategoryDto[] categories = restTemplate.getForObject(url, CategoryDto[].class);
        if (categories != null)
            return List.of(categories);
        return null;
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(long categoryId) {
        String url = inventoryServiceUrl + "/products/" + categoryId;
        RestTemplate restTemplate = new RestTemplate();
        ProductDto[] products = restTemplate.getForObject(url, ProductDto[].class);
        if (products != null)
            return List.of(products);
        return null;
    }

    @Override
    public ProductDto getProductById(long productId) {
        String url = inventoryServiceUrl + "/product/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, ProductDto.class);
    }

}
