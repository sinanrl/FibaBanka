package com.so.spring.client;

import com.so.spring.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping
public class ProductController {

    @GetMapping("/product/get")
    @ResponseBody
    public String getProduct() {
        long productId = 301;
        String url = "http://localhost:8080/api/products/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(url, Product.class);

        return "Edinme başarılı " + product.getProductName();
    }

    @GetMapping("/product/post")
    @ResponseBody
    public String postProduct() {
        String url = "http://localhost:8080/api/products";
        RestTemplate restTemplate = new RestTemplate();
        Product product = new Product(123, "post", 1234);
        String response = restTemplate.postForObject(url, product, String.class);

        return "Edinme başarılı " + product.getProductName();
    }

    @GetMapping("/product/put")
    @ResponseBody
    public String putProduct() {
        Product product = new Product(0, "sinan", 456);
        String url = "http://localhost:8080/api/products";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(product), Void.class);

        return "Güncelleme başarılı " + product.getProductName();
    }

    @GetMapping("/product/delete")
    @ResponseBody
    public String deleteProduct() {
        long productId = 3;
        String url = "http://localhost:8080/api/products" + productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);

        return "Silme başarılı";
    }

}

