package ru.gb.prev;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private List<Order> order;

    public OrderRepository() {
        this.order = new ArrayList<Order>(
                List.of(
                        new Order(1,2,3,"dsa"),
                        new Order(2,22,33,"dsaa")

                )
        );
    }

    public Optional<Order> findById(int id) {
        return order.stream().filter(p -> p.getId() == id).findFirst();
    }
    public Optional<Order> findByProducts(String product) {
        return order.stream().filter(p -> p.getProducts() == product).findFirst();
    }

    public List<Order> findAll() {
        return order;
    }

    public void add(Order order) {
        this.order.add(order);
    }

    @Override
    public String toString() {
        return "OrderRepository{" +
                "order=" + order +
                '}';
    }
}
