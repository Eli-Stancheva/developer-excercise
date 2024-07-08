package com.example.groceriesshop.repository;

import com.example.groceriesshop.models.Products;

import java.util.Map;

public interface ProductsRepository {
    void addProduct(Products product);
    Map<String, Double> getAllProducts();
    Products findByName(String name);
}
