package ru.gb.web.application;

public class Product {
    public int id;
    public int title;
    public int cost;
    public Product(int id,int title,int cost) {
        this.id=id;
        this.title=title;
        this.cost=cost;
    }

    public int getId() {
        return id;
    }

    public int getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }
}
