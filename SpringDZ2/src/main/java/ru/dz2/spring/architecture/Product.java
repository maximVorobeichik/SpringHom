package ru.dz2.spring.architecture;

import org.springframework.context.annotation.Bean;

public class Product {
    private int id;
    private String name;
    private int cost;



    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
