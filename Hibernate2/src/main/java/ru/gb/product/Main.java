package ru.gb.product;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {


    public static void main(String[] args) {


        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ContextConf.class);
        DaoProducts daoProducts=context.getBean(DaoProducts.class);
        daoProducts.Create();
        daoProducts.FindProductsByIdBuyer(1);

    }






}
