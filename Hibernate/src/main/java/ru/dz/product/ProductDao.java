package ru.dz.product;

import org.hibernate.cfg.Configuration;
import ru.gb.school.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaDelete;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ProductDao {
    static EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); //создаем фабрику менджеров ,для дальнейшего создания мененджеров
    static EntityManager entityManager = factory.createEntityManager();


    public static void main(String[] args) {

        createDb();
        Product productFindId= findById((long) 22); //поиск по id
        List<Product> productList=findAll();   //вывод всей бд
        saveOrUpdate(new Product(132,"dd",323)); //добавление элемента
        deleteById((long) 22); // удаление



    }




    static void createDb(){
        ArrayList<Product> productsList=new ArrayList<>();
        productsList.add(new Product(12,"sa1",5434));
        productsList.add(new Product(22,"sa2",5424));
        productsList.add(new Product(32,"sa3",5414));
        productsList.add(new Product(42,"sa4",2544));
        productsList.add(new Product(52,"sa5",4544));


        entityManager.getTransaction().begin();
        for(Product localProduct:productsList){
            entityManager.persist(localProduct);
        }
        entityManager.getTransaction().commit();
    }

    static Product findById(Long id){
        entityManager.getTransaction().begin();
        Product author = entityManager.createQuery("SELECT a FROM Product a WHERE a.id ="+id, Product.class).getSingleResult();
        entityManager.getTransaction().commit();
        return author;
    }
    static List<Product> findAll(){
        entityManager.getTransaction().begin();
        List<Product> products = entityManager.createNamedQuery("Product.FindAll", Product.class).getResultList();
        entityManager.getTransaction().commit();
        return products;
    }
    static  void saveOrUpdate(Product product){
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }
    static void deleteById(long id){
        entityManager.remove(findById( id));
    }
}
