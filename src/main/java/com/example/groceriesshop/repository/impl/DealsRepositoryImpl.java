package com.example.groceriesshop.repository.impl;

import com.example.groceriesshop.models.Products;
import com.example.groceriesshop.repository.DealsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DealsRepositoryImpl implements DealsRepository {
    private final List<Products> twoForThreeItems = new ArrayList<>();
    private final List<Products> buyOneGetOneHalfPriceItems = new ArrayList<>();

    @Override
    public void addTwoForThreeItem(Products product) {
        if (twoForThreeItems.size() >= 3) {
            throw new IllegalArgumentException("Cannot add more than 3 products to the 'Two for Three' deal.");
        }

        twoForThreeItems.add(product);
    }

    @Override
    public void addBuyOneGetOneHalfPriceItem(Products product) {
        if (buyOneGetOneHalfPriceItems.size() >= 1) {
            throw new IllegalArgumentException("Cannot add more than 1 product to the 'Buy one get one half price' deal.");
        }
        buyOneGetOneHalfPriceItems.add(product);
    }

    @Override
    public List<Products> getTwoForThreeItems() {
        return twoForThreeItems;
    }

    @Override
    public List<Products> getBuyOneGetOneHalfPriceItems() {
        return buyOneGetOneHalfPriceItems;
    }

    @Override
    public List<String> getTwoForThreeNames() {
        List<String> twoForThreeDeal = new ArrayList<>();
        for (Products product : twoForThreeItems) {
            twoForThreeDeal.add(product.getName());
        }
        return twoForThreeDeal;
    }

    @Override
    public List<String> getBuyOneGetOneHalfPriceNames() {
        List<String> buyOneGetOneHalfPriceDeal = new ArrayList<>();
        for (Products product : buyOneGetOneHalfPriceItems) {
            buyOneGetOneHalfPriceDeal.add(product.getName());
        }
        return buyOneGetOneHalfPriceDeal;
    }
}
