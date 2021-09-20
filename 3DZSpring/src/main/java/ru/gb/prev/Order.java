package ru.gb.prev;

public class Order {
    private int id;
    private int date;
    private int cost;
    private String products;

    public Order(int id, int date, int cost, String products) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.products = products;
    }

    public Order() {

    }

    public int getId() {
        return id;
    }

    public int getDate() {
        return date;
    }

    public int getCost() {
        return cost;
    }

    public String getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", cost=" + cost +
                ", products='" + products + '\'' +
                '}';
    }
}
