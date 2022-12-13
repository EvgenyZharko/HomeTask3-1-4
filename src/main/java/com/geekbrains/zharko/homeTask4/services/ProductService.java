package com.geekbrains.zharko.homeTask4.services;

import com.geekbrains.zharko.homeTask4.data.Product;
import com.geekbrains.zharko.homeTask4.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public void changeCost(Long productId, Integer delta) {
        Product product = productRepository.findById(productId);
        product.setCost(product.getCost() + delta);
    }
}
