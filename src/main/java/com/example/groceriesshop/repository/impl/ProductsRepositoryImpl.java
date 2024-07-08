package com.example.groceriesshop.repository.impl;

import com.example.groceriesshop.models.Products;
import com.example.groceriesshop.repository.ProductsRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductsRepositoryImpl implements ProductsRepository {
    private final Map<String, Double> products = new HashMap<>();

    @Override
    public void addProduct(Products product) {
        products.put(product.getName(), product.getPrice());
    }

    @Override
    public Map<String, Double> getAllProducts() {
        return products;
    }

    @Override
    public Products findByName(String name) {
        Double price = products.get(name);
        if (price != null) {
            return new Products(name, price);
        } else {
            return null;
        }
    }
}
