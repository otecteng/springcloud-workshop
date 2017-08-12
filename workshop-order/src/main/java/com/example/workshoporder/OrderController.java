package com.example.workshoporder;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public List<Order> list(){
        rabbitTemplate.convertAndSend("spring-boot", "Hello from RabbitMQ!");
        return orderRepository.findAll();
    }

    @PostMapping
    public Order create(@RequestBody Order request){
        return orderRepository.save(request);
    }

    @GetMapping(value = "{id}")
    public Order get(@PathVariable String id){
        return orderRepository.findOne(id);
    }

    @PutMapping
    public Order update(){
        return new Order();
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable String id){
        orderRepository.delete(id);
    }
}

