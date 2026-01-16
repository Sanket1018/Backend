package com.Product.Product.repository;

import com.Product.Product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    // gives the inbuilt methods

    // optional is used to avoid the null pointer exception it means it may contain null also
    // optional is like return type
      Optional<Category> findByName(String categoryName);
}
