package com.Product.Product.mapper;

import com.Product.Product.dto.CategoryDTO;
import com.Product.Product.entity.Category;

import java.util.stream.Collectors;

public class CategoryMapper {
    // dto into entity
    public static Category categoryDTOToEnity(CategoryDTO categoryDTO)
    {
       // The data is coming from the dto we have to set to the enoity
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return category;
    }

    // entity to dto
    public static CategoryDTO categoryEntityToDTO(Category category)
    {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        // Here needs a list products so we need first productdto and then we converting it into dto and again for display  into list
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).collect(Collectors.toList()));
        return categoryDTO;
    }
}
