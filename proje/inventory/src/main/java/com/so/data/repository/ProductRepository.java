package com.so.data.repository;

import com.so.data.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findProductsByCategoryId(long categoryId);
}
