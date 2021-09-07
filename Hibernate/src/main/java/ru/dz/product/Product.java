package ru.dz.product;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT")
@NamedQueries({
        @NamedQuery(name = "Product.FindAll", query = "SELECT a FROM Product a")


})
public class Product {
    @Id
    @GeneratedValue
    private int idProduct;

   // @OnDelete( action = OnDeleteAction.CASCADE ) ????????????????????????????
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private int price;

    public Product(int idProduct,long id, String title, int price) {
        this.idProduct=idProduct;
        this.id = id;
        this.title = title;
        this.price = price;
    }
    public Product(long id, String title, int price) {
        this.id=id;
        this.title = title;
        this.price = price;
    }

    public Product() {

    }





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
