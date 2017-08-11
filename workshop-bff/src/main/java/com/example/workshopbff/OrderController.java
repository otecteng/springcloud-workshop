package com.example.workshopbff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired OrderClient orderClient;
    @Autowired ProductClient productClient;

    @GetMapping
    public List<Order> list(){
        return orderClient.list();
    }

    @PostMapping
    public Order create(@RequestBody Order request){
        return (Order)orderClient.create(request);
    }
}
