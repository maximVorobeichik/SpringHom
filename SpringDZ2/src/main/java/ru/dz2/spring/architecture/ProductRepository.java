package ru.dz2.spring.architecture;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public  class ProductRepository {

    public static    List<Product> listSecond = new ArrayList<Product>();



    public void productAdd(Product product){
        listSecond.add(product);
    }
    public Product productGetId(int id){


        Product productReturn=null;
        for(Product product:listSecond){

            if(product.getId()==id){
                productReturn= product;


            }
        }

       return productReturn;
    }
    public void deleteAll(){
        listSecond.clear();
    }
    public void getAll(){
        System.out.println(listSecond);
    }

    @PostConstruct
    public void postConst(){
       productAdd(new Product(1,"ee1",333));
        productAdd(new Product(2,"ee2",321));
        productAdd(new Product(3,"ee3",213));
        productAdd(new Product(4,"ee4",213));
        productAdd(new Product(5,"ee5",443));
    }


}
