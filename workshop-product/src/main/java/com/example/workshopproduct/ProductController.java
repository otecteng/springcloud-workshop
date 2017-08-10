package com.example.workshopproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired ProductRepository productRepository;

    @GetMapping
    public List<Product> list(){
        return productRepository.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product request){
        return productRepository.save(request);
    }

    @GetMapping(value = "{id}")
    public Product get(@PathVariable String id){
        return productRepository.findOne(id);
    }

    @PutMapping
    public Product update(){
        return new Product();
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable String id){
        productRepository.delete(id);
    }
}
