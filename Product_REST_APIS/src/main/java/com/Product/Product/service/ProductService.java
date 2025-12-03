package com.Product.Product.service;

import com.Product.Product.dto.CategoryDTO;
import com.Product.Product.dto.ProductDTO;
import com.Product.Product.entity.Category;
import com.Product.Product.entity.Product;
import com.Product.Product.mapper.ProductMapper;
import com.Product.Product.repository.CategoryRepository;
import com.Product.Product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    // Logic of the products
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    // create a new product logic
    public ProductDTO createProduct(ProductDTO productDTO)
    {

       // we want to save the category id into the product because we want return it with product
       Category category= categoryRepository.findById(productDTO.getCategoryId())
               .orElseThrow(()-> new RuntimeException("Category not found"));

        // Product DTO to entity for saving
        Product product  = ProductMapper.toProductEntity(productDTO,category);
        product = productRepository.save(product);

       // Now we have to convert it into dto again
        productDTO = ProductMapper.toProductDTO(product);
        return productDTO;
    }
}


