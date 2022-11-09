package com.so.business.service;

import com.so.business.dto.CartDto;
import com.so.business.dto.CartProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ShoppingServiceImpl implements ShoppingService {

    @Value("${shoppingservice.url}")
    private String shoppingServiceUrl;

    @Override
    public long createCart() {
        String url = shoppingServiceUrl + "/create";
        RestTemplate restTemplate = new RestTemplate();
        long cartId = restTemplate.getForObject(url, long.class);
        return cartId;
    }

    @Override
    public void addToCart(CartProductDto cartProductDto) {
        String url = shoppingServiceUrl + "/add";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url, cartProductDto, void.class);
    }

    @Override
    public void removeFromCart(long cartId, long productId) {
        String url = shoppingServiceUrl + "/" + cartId + "/remove/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url, cartId, productId);
    }

    @Override
    public long checkout(long cartId) {
        String url = shoppingServiceUrl + "/checkout/" + cartId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(url, long.class, cartId);
        return cartId;
    }

    @Override
    public CartDto getCartById(long cartId) {
        RestTemplate restTemplate = new RestTemplate();

        String url1 = shoppingServiceUrl + "/find?cartId={cartId}";
        CartDto cartDto = restTemplate.getForObject(url1, CartDto.class, cartId);

        String url2 = shoppingServiceUrl + "/" + cartId + "/cartproducts";
        CartProductDto[] cartProducts = restTemplate.getForObject(url2, CartProductDto[].class);



        cartDto.setCartProducts(List.of(cartProducts));

        return cartDto;
    }
}
