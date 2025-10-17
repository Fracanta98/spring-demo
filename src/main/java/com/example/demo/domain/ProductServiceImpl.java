package com.example.demo.domain;
import com.example.demo.data.ProductRepository;
import com.example.demo.data.entities.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private  final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long insert(ProductEntity product) {
        ProductEntity savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    @Override
    public List<ProductEntity> findAll() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public ProductEntity updateById(Long id, ProductEntity product) {
        ProductEntity updatedProduct = productRepository.findById(id).get();
                    //il controllo dei null nel controller?
                    updatedProduct.setName(product.getName());
                    updatedProduct.setPrice(product.getPrice());
                    productRepository.save(updatedProduct);

                return updatedProduct;


    }
}
