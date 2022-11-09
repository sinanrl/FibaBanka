package com.so.business.service;

import com.so.business.dto.CartDto;
import com.so.data.entity.Cart;
import com.so.data.entity.CartProduct;
import com.so.data.repository.CartProductRepository;
import com.so.data.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;

    public CartServiceImpl(CartRepository cartRepository, CartProductRepository cartProductRepository) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public long create() {
        Cart cart = new Cart();
        cart.setCartStatus(false);
        cart.setCustomerName("sinan" + Math.random() * 10);
        cart.setTotalAmount(0);

        Cart createdCart = cartRepository.save(cart);

        return createdCart.getCartId();
    }

    @Override
    public void checkout(long cartId) {
        cartRepository.checkout(cartId);
    }

    @Override
    public CartDto findCartById(long id) {
        Optional<Cart> optional = cartRepository.findById(id);
        return optional.map(this::cartToCartDto).orElse(null);
    }

    private CartDto cartToCartDto(Cart cart) {
        return new CartDto(cart.getCartId(), cart.getCustomerName(), cart.getTotalAmount(), cart.isCartStatus());
    }
}
