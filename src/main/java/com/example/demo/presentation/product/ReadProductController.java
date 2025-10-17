package com.example.demo.presentation.product;

import com.example.demo.presentation.product.dto.ProductResponse;
import com.example.demo.presentation.product.dto.ProductsResponse;

public interface ReadProductController {
    ProductResponse getProductById(Long id);
    ProductsResponse getAllProducts();
}
