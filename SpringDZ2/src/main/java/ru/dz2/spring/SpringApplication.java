package ru.dz2.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dz2.spring.architecture.*;

public class SpringApplication {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext context1=new AnnotationConfigApplicationContext(SpringContextConf.class);
        //ProductRepository productRepository=context1.getBean(ProductRepository.class);
      //  productRepository.getAll();
        Cart cart=context1.getBean(Cart.class);

    //вызываем 1 корзину
        cart.UseCart();
        //создаем новую корзину

        Cart cart2=context1.getBean(Cart.class);
        cart2.UseCart();
    }
}
