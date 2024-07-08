package com.example.groceriesshop.repository;

import com.example.groceriesshop.models.Products;

import java.util.List;

public interface DealsRepository {
    void addTwoForThreeItem(Products product);
    void addBuyOneGetOneHalfPriceItem(Products product);
    List<Products> getTwoForThreeItems();
    List<Products> getBuyOneGetOneHalfPriceItems();
    List<String> getTwoForThreeNames();
    List<String> getBuyOneGetOneHalfPriceNames();
}
