package com.so.data.repository;

import com.so.data.entity.CartProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartProductRepository extends CrudRepository<CartProduct, Long> {

    @Transactional
    void deleteByCartIdAndProductId(long cartId, long productId);

    List<CartProduct> findAllByCartId(long cartId);
}
