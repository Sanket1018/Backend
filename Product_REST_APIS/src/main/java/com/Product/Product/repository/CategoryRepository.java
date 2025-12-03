package com.Product.Product.repository;

import com.Product.Product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    // gives the inbuilt methods
}
