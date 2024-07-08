package com.example.groceriesshop.survice;

import com.example.groceriesshop.models.Products;

import java.util.List;

public interface DealsService {
    void addProductToTwoForThree(String productName);
    void addProductToBuyOneGetOneHalfPrice(String productName);
    List<Products> getTwoForThreeItems();
    List<Products> getBuyOneGetOneHalfPriceItems();
}
