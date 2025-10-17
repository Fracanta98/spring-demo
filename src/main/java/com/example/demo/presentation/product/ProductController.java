package com.example.demo.presentation.product;

import com.example.demo.data.entities.ProductEntity;
import com.example.demo.domain.ProductService;
import com.example.demo.presentation.product.dto.ProductRequest;
import com.example.demo.presentation.product.dto.ProductResponse;
import com.example.demo.presentation.product.dto.ProductsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v2")
public class ProductController implements WriteProductController, ReadProductController {

    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @PostMapping
    public Long createProduct(
            @RequestBody
            ProductRequest product) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.name());
        productEntity.setPrice(product.price());

        return productService.insert(productEntity);
    }


    @GetMapping("/products/{id}")
    public ProductResponse getProductById(
            @PathVariable("id")
           Long id) {

        ProductEntity productEntity = productService.findById(id);
        if (productEntity == null) {
            return null;
        }

        return new ProductResponse(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getPrice()
        );
    }

    @Override
    @PostMapping("/products")
    public ProductsResponse getAllProducts() {
        List<ProductEntity> products = productService.findAll();
        List<ProductResponse> productResponses = products.stream().map( productEntity -> new ProductResponse(
               productEntity.getId(),
               productEntity.getName(),
               productEntity.getPrice()
        )).toList();

        return new  ProductsResponse(productResponses);
    }
}
