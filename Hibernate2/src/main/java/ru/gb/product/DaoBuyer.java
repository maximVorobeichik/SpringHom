package ru.gb.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class DaoBuyer {
    private EntityManagerFactory factory;

    public DaoBuyer(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public Buyer FindBuyerFromIdProduct(int id){
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        //List<Buyer> author = entityManager.createQuery("SELECT a.buyer FROM Product a  WHERE a.ProductId ="+id, Buyer.class).;
        Buyer author= entityManager.createQuery("SELECT a.buyer FROM Product a  WHERE a.ProductId ="+id, Buyer.class).getSingleResult();

        entityManager.getTransaction().commit();

        return author;
    }

    public void Create(){



    }
}
