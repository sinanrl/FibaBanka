package com.so.business.service;

import com.so.business.dto.CartProductDto;
import com.so.data.entity.CartProduct;
import com.so.data.repository.CartProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartProductServiceImpl implements CartProductService{

    private final CartProductRepository cartProductRepository;

    public CartProductServiceImpl(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public void add(CartProductDto cartProductDto) {
        cartProductRepository.save(cartProductDtoToCartProduct(cartProductDto));
    }

    @Override
    public void remove(long cartId, long productId) {
        cartProductRepository.deleteByCartIdAndProductId(cartId, productId);
    }

    @Override
    public List<CartProductDto> getCartProductsByCartId(long cartId) {
        return cartProductListToCartProductDtoList(cartProductRepository.findAllByCartId(cartId));
    }

    private List<CartProductDto> cartProductListToCartProductDtoList(List<CartProduct> cartProductList)
    {
        ArrayList<CartProductDto> cartProductDtos = new ArrayList<>();
        for(CartProduct cartProduct : cartProductList) {
            cartProductDtos.add(cartProductToCartProductDto(cartProduct));
        }

        return cartProductDtos;
    }

    private CartProductDto cartProductToCartProductDto(CartProduct cartProduct)
    {
        return new CartProductDto(
                cartProduct.getCartProductId(),
                cartProduct.getCartId(),
                cartProduct.getProductId(),
                cartProduct.getSalesQuantity(),
                cartProduct.getSalesPrice(),
                cartProduct.getLineAmount()
        );
    }

    private CartProduct cartProductDtoToCartProduct(CartProductDto cartProductDto)
    {
        return new CartProduct(
                cartProductDto.getCartProductId(),
                cartProductDto.getCartId(),
                cartProductDto.getProductId(),
                cartProductDto.getSalesQuantity(),
                cartProductDto.getSalesPrice(),
                cartProductDto.getLineAmount()
        );
    }
}
