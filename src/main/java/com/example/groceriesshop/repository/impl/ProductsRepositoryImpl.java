package com.example.groceriesshop.repository.impl;

import com.example.groceriesshop.models.Products;
import com.example.groceriesshop.repository.ProductsRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


/**
 * Имплементация на интерфейса ProductsRepository за управление на продуктите в магазина.
 */
@Repository
public class ProductsRepositoryImpl implements ProductsRepository {
    private final Map<String, Double> products = new HashMap<>();

    /**
     * Добавя нов продукт в репозитория.
     *
     * @param product Продуктът, който ще бъде добавен
     */
    @Override
    public void addProduct(Products product) {
        products.put(product.getName(), product.getPrice());
    }

    /**
     * Връща карта с всички продукти в репозитория.
     *
     * @return Карта с имената на продуктите като ключове и техните цени като стойности
     */
    @Override
    public Map<String, Double> getAllProducts() {
        return products;
    }

    /**
     * Намира продукт по име в репозитория.
     *
     * @param name Името на продукта, който се търси
     * @return Продуктът с даденото име или null, ако не съществува
     */
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
