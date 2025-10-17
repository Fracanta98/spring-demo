package com.example.demo.presentation.product;

import com.example.demo.presentation.product.dto.ProductRequest;

public interface WriteProductController {
    Long createProduct(ProductRequest product);
}
