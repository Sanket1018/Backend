package com.Product.Product.service;

import com.Product.Product.dto.CategoryDTO;
import com.Product.Product.entity.Category;
import com.Product.Product.exception.CategoryAlreadyExistsException;
import com.Product.Product.mapper.CategoryMapper;
import com.Product.Product.mapper.ProductMapper;
import com.Product.Product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO)
    {
        // Here now we are handling the duplicate category exception
        Optional<Category> optional= categoryRepository.findByName(categoryDTO.getName());

        if(optional.isPresent())
        {
            throw new CategoryAlreadyExistsException("category"+categoryDTO.getName()+" is already exists");
        }







        // We have to save the data to the database.
        Category category= CategoryMapper.categoryDTOToEnity(categoryDTO);

        // Here we saved the category
        // Now we have to entity to dto
        category = categoryRepository.save(category);
        return CategoryMapper.categoryEntityToDTO(category);
    }

    // Get All categories
    public List<CategoryDTO> getAllcategories(){
        // entity to dto using stream
          return categoryRepository.findAll()
                  .stream().map(CategoryMapper::categoryEntityToDTO).toList();
    }

    // Get a category by id
    public CategoryDTO getCategoryById(Long id)
    {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        // now we found the category by id and this is the entity

        // we have to convert it into dto
         CategoryDTO categoryDTO = CategoryMapper.categoryEntityToDTO(category);
         return categoryDTO;
    }

    // Delete category
    public String deleteCategory(Long id)
    {
        categoryRepository.deleteById(id);
        return "category"+id+" successfully deleted";
    }

}
