package com.example.groceriesshop.repository;

import com.example.groceriesshop.models.Products;

import java.util.List;

/**
 * Интерфейс за управление на сделките в магазина.
 */
public interface DealsRepository {

    /**
     * Добавя продукт в списъка за сделката "Две за три".
     *
     * @param product Продуктът, който ще бъде добавен
     */
    void addTwoForThreeItem(Products product);

    /**
     * Добавя продукт в списъка за сделката "Купи едно, получи едно на половин цена".
     *
     * @param product Продуктът, който ще бъде добавен
     */
    void addBuyOneGetOneHalfPriceItem(Products product);

    /**
     * Връща списъка с продукти за сделката "Две за три".
     *
     * @return Списък с продукти
     */
    List<Products> getTwoForThreeItems();

    /**
     * Връща списъка с продукти за сделката "Купи едно, получи едно на половин цена".
     *
     * @return Списък с продукти
     */
    List<Products> getBuyOneGetOneHalfPriceItems();

    /**
     * Връща имената на продуктите за сделката "Две за три".
     *
     * @return Списък с имената на продуктите
     */
    List<String> getTwoForThreeNames();

    /**
     * Връща имената на продуктите за сделката "Купи едно, получи едно на половин цена".
     *
     * @return Списък с имената на продуктите
     */
    List<String> getBuyOneGetOneHalfPriceNames();
}
