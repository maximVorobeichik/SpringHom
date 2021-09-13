package ru.gb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.domain.Order;
import ru.gb.domain.Product;
import ru.gb.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")

public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

@GetMapping
    public List<Order> list(){
        return orderRepository.findAll();
}
@GetMapping("{id}")
    public Optional<Order> findById(@PathVariable int id){
        return orderRepository.findById(id);
}

@PostMapping
    public void add(@RequestBody Order order){
        System.out.println(order);
        orderRepository.add(order);
}

@DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        orderRepository.remove(id);
}


}
