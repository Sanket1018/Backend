package com.Product.Product.controller;

import com.Product.Product.dto.CategoryDTO;
import com.Product.Product.entity.Category;
import com.Product.Product.exception.CategoryAlreadyExistsException;
import com.Product.Product.service.CategoryService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
@Tag(
        name = "Category REST API CURD operation",
        description = "CREATE READ UPDATE DELETE operations for category REST API"
)
@ApiResponse(
        responseCode = "201",
        description = "created"
)
public class CategoryController {
    private CategoryService categoryService;
    //create a category

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {

            CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
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

    //delete the category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id)
    {
        categoryService.deleteCategory(id);
        return "Category"+id+" is deleted successfully";
    }
}
