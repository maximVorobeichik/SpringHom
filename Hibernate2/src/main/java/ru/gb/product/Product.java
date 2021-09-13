package ru.gb.product;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue
    private int ProductId;
    private int id;
    private String name;
    private int cost;
    @ManyToOne
    @JoinColumn(name="Buyer_id",nullable = false)
    private Buyer buyer;
    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", buyer=" + buyer +
                '}';
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Product(int productId, int id, String name, int cost) {
        ProductId = productId;
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Product(int id, String name, int cost, Buyer buyer) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.buyer = buyer;
    }

    public Product(int productId, int id, String name, int cost, Buyer buyer) {
        ProductId = productId;
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.buyer = buyer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getProductId() {
        return ProductId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
