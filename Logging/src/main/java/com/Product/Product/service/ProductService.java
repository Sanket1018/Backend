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

import java.util.List;

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

    // Get all products
    public List<ProductDTO> getAllProducts()
    {
        // need to convert entity to dto list
       return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    // Get a product by id
    public ProductDTO getProductById(Long id)
    {
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Prduct not found"));

        // need to convert entity to dto
        return ProductMapper.toProductDTO(product);
    }

    // Update the product by id
    public ProductDTO updateProductById(Long id,ProductDTO productDTO)
    {
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product is not found plz check it properly"));

        //we have to take product dto and we need also category id
        //for this we are going to chek the category id is present or not
        Category category= categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("Category id is nor found"));

        // Now we need to check product is present or not and we have to set the entity

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);

        // we are saving the updated product
        productRepository.save(product);

        // for the returning updated product we have to convert the product entity to the dto
        return ProductMapper.toProductDTO(product);
    }

    // delete product by id
    // Just we need delete it from the entity
    public String deleteProductById(Long id)
    {
        productRepository.deleteById(id);
        return "product"+id+"deleted successfully";
    }


}


