package ru.gb.current.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.prev.Order;
import ru.gb.prev.OrderRepository;
import ru.gb.prev.Product;
import ru.gb.prev.ProductRepository;

@Controller
public class ProductController {

    private final ProductRepository repository;
    private final OrderRepository orderRepository;

    public ProductController(ProductRepository repository, OrderRepository orderRepository) {
        this.repository = repository;
        this.orderRepository = orderRepository;
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("products", repository.findAll());
        return "products";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        // #TODO TO BE DEFINED LATER
        return "products";
    }
    // без понятия как работать с DELETE что-бы через него удалять записи(не нагуглил) поэтому через get сделал 
    @RequestMapping(value = "/products/delete/{id}", method = RequestMethod.GET)
    public String delete2(@PathVariable int id) {
       repository.Delete(id);
        return "products";
    }



    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "products-add";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String add(Product product) {

        repository.add(product);
        return "products";
    }

    //с jsp файлом обьекты добавляет но они всегда -0 , как поправить я хз, по этому добавил запрос на добавление обьектов через адресс
    @RequestMapping(value = "/products/add/{id}/{name}/{price}", method = RequestMethod.GET)
    public String add(@PathVariable int id,@PathVariable String name,@PathVariable float price){
        repository.add(new Product(id,name,price));
        return "products";

    }






    @RequestMapping(value = "/order/add", method = RequestMethod.GET)
    public String orderAdd(Model model) {
        model.addAttribute("order", new Order());

        return "order-add";
    }
    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String orderAdd(Order order) {

        orderRepository.add(order);
        return "order";
    }




    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String findAllOrder(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "order";
    }




}
