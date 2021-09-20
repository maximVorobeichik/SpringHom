package ru.gb.product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BUYER")
public class Buyer {
    @Id
    @GeneratedValue
    private int buyerId;
    private int id;
    private String name;
    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<Product> product;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProduct() {
        return product;
    }
    public void addProduct(Product inputProduct){
        product.add(inputProduct);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "buyerId=" + buyerId +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Buyer() {
    }

    public Buyer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Buyer(int id, String name, List<Product> product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }

    public Buyer(int buyerId, int id, String name, List<Product> product) {
        this.buyerId = buyerId;
        this.id = id;
        this.name = name;
        this.product = product;
    }
}
