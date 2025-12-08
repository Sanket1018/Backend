package com.Product.Product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@OpenAPIDefinition(
    info = @Info(
        title = "Product Service REST API documentation",
        description = "Product Service REST API",
        version = "v1",
        contact = @Contact (
            name = "Sanket Khokade",
            email = "sanketkhokadesk@gmail.com"

            )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Product API Development"

        )

    )

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
