package com.Product.Product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(
        name = "Category",
        description = "It holds category information with their products"
)
public class CategoryDTO {
    private Long id;
    private String name;

    private List<ProductDTO> products;
}
