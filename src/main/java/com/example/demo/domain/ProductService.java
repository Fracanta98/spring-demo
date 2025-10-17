package com.example.demo.domain;
import com.example.demo.data.entities.ProductEntity;



import java.util.List;

public interface ProductService {
    Long insert(ProductEntity product );
    List<ProductEntity> findAll();
    ProductEntity findById(Long id);
    ProductEntity updateById(Long id, ProductEntity product);


}
