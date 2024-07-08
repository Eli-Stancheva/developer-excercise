package com.example.groceriesshop.survice;

import com.example.groceriesshop.models.Products;

import java.util.List;
import java.util.Map;

public interface ProductsService {
    void addProducts(List<Products> productsList);
    Map<String, Double> getAllProducts();
    String calculateTotalCost(List<String> basket);
    double calculateOneForHalf(Map<String, Double> products, double totalCost, Map<String, Integer> itemCount);
    double calculateTwoForThree(List<String> basket, Map<String, Double> products, double totalCost, Map<String, Integer> itemCount);
    Map<String, Integer> getItemCount(List<String> basket);
}
