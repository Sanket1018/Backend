package com.Product.Product.controller;

import com.Product.Product.dto.CategoryDTO;
import com.Product.Product.entity.Category;
import com.Product.Product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    //create a category
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO)
    {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    //Get all categories
    @GetMapping
    public List<CategoryDTO> getAllCategories(Category category)
    {
        return categoryService.getAllcategories();
    }

    //Get category by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id)
    {
        return new ResponseEntity<>( categoryService.getCategoryById(id),HttpStatus.OK);
    }

    //update the category by id

    //delete the category by id
    //delete all categories

}
