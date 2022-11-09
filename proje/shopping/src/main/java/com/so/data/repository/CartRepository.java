package com.so.data.repository;

import com.so.data.entity.Cart;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CartRepository extends CrudRepository<Cart, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Cart c set c.cartStatus = true where c.cartId = ?1")
    void checkout(long cartId);
}
