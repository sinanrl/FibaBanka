package com.so.business.service;

import com.so.business.dto.ProductDto;
import com.so.data.entity.Product;
import com.so.data.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> findProductsByCategoryId(long categoryId) {
        List<Product> products = productRepository.findProductsByCategoryId(categoryId);
        return productListToProductDtoList(products);
    }

    @Override
    public ProductDto findProductById(long productId) {
        Optional<Product> optional = productRepository.findById(productId);
        return optional.map(this::productToProductDto).orElse(null);

    }

    private List<ProductDto> productListToProductDtoList(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(productToProductDto(product));
        }

        return productDtos;
    }

    private ProductDto productToProductDto(Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getSalesPrice(),
                product.getCategoryId()
        );
    }
}
