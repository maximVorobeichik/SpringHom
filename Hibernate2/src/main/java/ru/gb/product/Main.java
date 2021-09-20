package ru.gb.product;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Main {


    public static void main(String[] args) {


        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ContextConf.class);
        DaoProducts daoProducts=context.getBean(DaoProducts.class);
        daoProducts.Create();
        daoProducts.FindProductsByIdBuyer(1);
        DaoBuyer daoBuyer=context.getBean(DaoBuyer.class);
       System.out.println(daoBuyer.FindBuyerFromIdProduct(3));


    }






}
