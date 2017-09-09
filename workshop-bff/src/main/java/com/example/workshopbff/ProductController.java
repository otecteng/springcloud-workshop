package com.example.workshopbff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired ProductClient productClient;

    @GetMapping
    public List<Product> list(){
        return productClient.list();
    }

}
