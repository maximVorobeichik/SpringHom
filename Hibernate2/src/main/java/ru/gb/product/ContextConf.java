package ru.gb.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConf {
    @Bean
    DaoProducts daoProducts(){
        return new DaoProducts();
    }
}
