package com.example.demo.controllers;

import com.example.demo.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    @GetMapping("/")
    public String hello()
    {
        return "Hello World";
    }

    @GetMapping("/products")
    public List<Product> getProducts() throws URISyntaxException, IOException, InterruptedException {
//        List<Product> productList = new ArrayList<>();
//        productList.add( new Product(){
//            {
//                id = 1;
//                name = "Product 1";
//                description = "Product 1 description";
//                price = 100;
//                title = "Product 1 title";
//                brand = "Product 1 brand";
//                imageUrl = "Product 1 image url";
//            }
//        });
//
//        productList.add( new Product(){{
//            id = 2;
//            name = "Product 2";
//            description = "Product 2 description";
//            price = 200;
//            title = "Product 2 title";
//            brand = "Product 2 brand";
//            imageUrl = "Product 2 image url";
//        }});
//
//        return productList;
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI("https://fakestoreapi.com/products")).GET().build();
        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        return new ArrayList<>();
    }
}
