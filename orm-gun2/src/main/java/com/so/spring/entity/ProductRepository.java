package com.so.spring.entity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByPriceIsGreaterThan(double minPrice);
}
