package com.geekbrains.zharko.homeTask4.repositories;

import com.geekbrains.zharko.homeTask4.data.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Milk", 100),
                new Product(2L, "Bread", 30),
                new Product(3L, "Eggs", 120),
                new Product(4L, "Cucumbers", 300),
                new Product(5L, "Beef", 800)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public Product findById(Long id) {
        return products.stream().filter((p -> p.getId().equals(id))).findFirst().get();
    }

}
