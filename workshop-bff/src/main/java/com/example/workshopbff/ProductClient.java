package com.example.workshopbff;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("product")
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "/products")
    String get();
}

