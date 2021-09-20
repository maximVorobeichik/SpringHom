package ru.gb.product;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class DaoProducts {
    private EntityManagerFactory factory;

    public DaoProducts(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public List<Product> FindProductsByIdBuyer(int id){
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Product> author = entityManager.createQuery("SELECT a FROM Product a  WHERE a.buyer ="+id, Product.class).getResultList();

        entityManager.getTransaction().commit();

        return author;
    }

    public void Create(){
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Buyer buyer=new Buyer(12,"Max");
        Buyer buyer1=new Buyer(11,"Dan");

        entityManager.persist(buyer);
        entityManager.persist(buyer1);

        Product product=new Product(1,"water",449,buyer);
        entityManager.persist(product);
        Product product2=new Product(2,"water2",4490,buyer);
        entityManager.persist(product2);


        entityManager.persist(product);


        entityManager.getTransaction().commit();



    }
}
