package com.example.workshopbff;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("product")
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "/products")
    List<Product> list();
}