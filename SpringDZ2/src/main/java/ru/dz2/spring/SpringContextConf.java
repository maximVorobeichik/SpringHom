package ru.dz2.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.dz2.spring.architecture.Cart;
import ru.dz2.spring.architecture.Product;
import ru.dz2.spring.architecture.ProductRepository;


@Configuration
public class SpringContextConf {




@Bean

ProductRepository productRepository(){

    return new ProductRepository();
}
@Bean
@Scope("prototype")
Cart cart(){
    return new Cart(new ProductRepository());
}
}
