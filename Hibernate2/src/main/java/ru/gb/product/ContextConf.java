package ru.gb.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
public class ContextConf {

   @Bean
    EntityManagerFactory entityManagerFactory(){
       return new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
   }

   @Bean
   DaoProducts daoProducts(EntityManagerFactory emf){
       return new DaoProducts(emf);
   }
   @Bean
    DaoBuyer daoBuyer(EntityManagerFactory emf){
       return new DaoBuyer(emf);
   }


}
