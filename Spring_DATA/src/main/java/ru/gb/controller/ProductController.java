package ru.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.domain.Product;
import ru.gb.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;

    }

    @GetMapping
    @ResponseBody
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
      //  repository.findAllByPriceIsIn(2,4).forEach(products::add);
        repository.findAll().forEach(products::add);
        return products;
    }

    @GetMapping("{id}")
    @ResponseBody
    public Product findById(@PathVariable int id) {
        return repository.findById(id).orElseThrow();
    }

    @GetMapping("delete/{id}")
    public void delete(@PathVariable int id) {
        repository.deleteById(id);


    }

    @PostMapping
    public List<Product> save(@RequestBody Product product) {
        repository.save(product);

        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        return products;
    }

}
