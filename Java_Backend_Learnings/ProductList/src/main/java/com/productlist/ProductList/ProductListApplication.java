package com.productlist.ProductList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductListApplication {



	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductListApplication.class, args);
		MyComponent component = context.getBean(MyComponent.class);
		component.message();

		MyApp myapp = context.getBean(MyApp.class);
		myapp.run();
	}

}
