package com.example.groceriesshop.repository;

import com.example.groceriesshop.models.Products;

import java.util.Map;

/**
 * Интерфейс за управление на продуктите в магазина.
 */
public interface ProductsRepository {

    /**
     * Добавя продукт в хранилището.
     *
     * @param product Продуктът, който ще бъде добавен
     */
    void addProduct(Products product);

    /**
     * Връща всички продукти в хранилището с техните цени.
     *
     * @return Карта от имената на продуктите и техните цени
     */
    Map<String, Double> getAllProducts();

    /**
     * Намира продукт по име в хранилището.
     *
     * @param name Името на продукта, който трябва да бъде намерен
     * @return Продуктът, ако бъде намерен; иначе null
     */
    Products findByName(String name);
}
