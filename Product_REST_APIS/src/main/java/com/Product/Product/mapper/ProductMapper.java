package com.Product.Product.mapper;

import com.Product.Product.dto.ProductDTO;
import com.Product.Product.entity.Category;
import com.Product.Product.entity.Product;

public class ProductMapper {

    // dto to entity
    public static Product toProductEntity(ProductDTO productDTO, Category category) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }

    // entity to dto
    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(product.getName(),product.getDescription(), product.getPrice(), product.getCategory().getId());
    }
}
