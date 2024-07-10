package com.example.groceriesshop.repository.impl;

import com.example.groceriesshop.models.Products;
import com.example.groceriesshop.repository.DealsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Имплементация на интерфейса DealsRepository за управление на офертите в магазина.
 */
@Repository
public class DealsRepositoryImpl implements DealsRepository {
    private final List<Products> twoForThreeItems = new ArrayList<>();
    private final List<Products> buyOneGetOneHalfPriceItems = new ArrayList<>();

    /**
     * Добавя продукт към офертата "Два за Три".
     *
     * @param product Продуктът, който ще бъде добавен
     * @throws IllegalArgumentException Ако се опита да се добавят повече от 3 продукта
     */
    @Override
    public void addTwoForThreeItem(Products product) {
        if (twoForThreeItems.size() >= 3) {
            throw new IllegalArgumentException("Cannot add more than 3 products to the 'Two for Three' deal.");
        }

        twoForThreeItems.add(product);
    }

    /**
     * Добавя продукт към офертата "Купи едно, вземи едно на половин цена".
     *
     * @param product Продуктът, който ще бъде добавен
     * @throws IllegalArgumentException Ако се опита да се добавят повече от 1 продукт
     */
    @Override
    public void addBuyOneGetOneHalfPriceItem(Products product) {
        if (buyOneGetOneHalfPriceItems.size() >= 1) {
            throw new IllegalArgumentException("Cannot add more than 1 product to the 'Buy one get one half price' deal.");
        }
        buyOneGetOneHalfPriceItems.add(product);
    }


    /**
     * Връща списък с продуктите в офертата "Два за Три".
     *
     * @return Списък с продуктите в офертата "Два за Три"
     */
    @Override
    public List<Products> getTwoForThreeItems() {
        return twoForThreeItems;
    }

    /**
     * Връща списък с продуктите в офертата "Купи едно, вземи едно на половин цена".
     *
     * @return Списък с продуктите в офертата "Купи едно, вземи едно на половин цена"
     */
    @Override
    public List<Products> getBuyOneGetOneHalfPriceItems() {
        return buyOneGetOneHalfPriceItems;
    }

    /**
     * Връща списък с имената на продуктите в офертата "Два за Три".
     *
     * @return Списък с имената на продуктите в офертата "Два за Три"
     */
    @Override
    public List<String> getTwoForThreeNames() {
        List<String> twoForThreeDeal = new ArrayList<>();
        for (Products product : twoForThreeItems) {
            twoForThreeDeal.add(product.getName());
        }
        return twoForThreeDeal;
    }

    /**
     * Връща списък с имената на продуктите в офертата "Купи едно, вземи едно на половин цена".
     *
     * @return Списък с имената на продуктите в офертата "Купи едно, вземи едно на половин цена"
     */
    @Override
    public List<String> getBuyOneGetOneHalfPriceNames() {
        List<String> buyOneGetOneHalfPriceDeal = new ArrayList<>();
        for (Products product : buyOneGetOneHalfPriceItems) {
            buyOneGetOneHalfPriceDeal.add(product.getName());
        }
        return buyOneGetOneHalfPriceDeal;
    }
}
