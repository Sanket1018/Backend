package com.productlist.ProductList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Myconfig {
    @Bean
    public MyComponent mycomponent(){
        return new MyComponent();
    }
}
