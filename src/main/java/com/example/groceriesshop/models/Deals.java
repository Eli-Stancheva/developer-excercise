package com.example.groceriesshop.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Deals {
    private final List<Products> twoForThreeItems = new ArrayList<>();
    private final List<Products> buyOneGetOneHalfPriceItems = new ArrayList<>();

    public List<Products> getTwoForThreeItems() {
        return twoForThreeItems;
    }

    public List<Products> getBuyOneGetOneHalfPriceItems() {
        return buyOneGetOneHalfPriceItems;
    }
}
