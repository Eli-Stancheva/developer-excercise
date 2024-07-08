package com.example.groceriesshop.survice.impl;

import com.example.groceriesshop.models.Products;
import com.example.groceriesshop.repository.impl.DealsRepositoryImpl;
import com.example.groceriesshop.repository.impl.ProductsRepositoryImpl;
import com.example.groceriesshop.survice.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductsServiceImpl implements ProductsService {
    private final ProductsRepositoryImpl productRepository;
    private final DealsRepositoryImpl dealsRepository;

    @Autowired
    public ProductsServiceImpl(ProductsRepositoryImpl productRepository, DealsRepositoryImpl dealsRepository) {
        this.productRepository = productRepository;
        this.dealsRepository = dealsRepository;
    }

    @Override
    public void addProducts(List<Products> productsList) {
        for (Products product : productsList) {
            productRepository.addProduct(product);
        }
    }

    @Override
    public Map<String, Double> getAllProducts() {
        return productRepository.getAllProducts();
    }


    @Override
    public String calculateTotalCost(List<String> basket) {
        Map<String, Double> products = productRepository.getAllProducts();

        double totalCost = 0;

        Map<String, Integer> itemCount = getItemCount(basket);
        totalCost = calculateTwoForThree(basket, products, totalCost, itemCount);
        totalCost = calculateOneForHalf(products, totalCost, itemCount);


        for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
            totalCost += entry.getValue() * products.get(entry.getKey());
        }

        return String.format("%d aws and %d clouds", (int)(totalCost / 100), (int)totalCost % 100);
    }

    @Override
    public double calculateOneForHalf(Map<String, Double> products, double totalCost, Map<String, Integer> itemCount) {
        for (String dealItem : dealsRepository.getBuyOneGetOneHalfPriceNames()) {
            if (itemCount.containsKey(dealItem)) {
                int count = itemCount.get(dealItem);
                int pairs = count / 2;
                int remainingItems = count % 2;

                totalCost += pairs * (products.get(dealItem) * 1.5);

                if (remainingItems > 0) {
                    totalCost += remainingItems * products.get(dealItem);
                }

                itemCount.put(dealItem, 0);
            }
        }
        return totalCost;
    }

    @Override
    public double calculateTwoForThree(List<String> basket, Map<String, Double> products, double totalCost, Map<String, Integer> itemCount) {
        List<String> twoForThreeBasket = new ArrayList<>();
        for (String item : basket) {
            if (dealsRepository.getTwoForThreeNames().contains(item)) {
                twoForThreeBasket.add(item);
                if (twoForThreeBasket.size() == 3) {
                    break;
                }
            }
        }

        if (twoForThreeBasket.size() == 3) {
            twoForThreeBasket.sort(Comparator.comparingDouble(products::get));
            totalCost += products.get(twoForThreeBasket.get(1)) + products.get(twoForThreeBasket.get(2));
            itemCount.put(twoForThreeBasket.get(0), itemCount.get(twoForThreeBasket.get(0)) - 1);
            itemCount.put(twoForThreeBasket.get(1), itemCount.get(twoForThreeBasket.get(1)) - 1);
            itemCount.put(twoForThreeBasket.get(2), itemCount.get(twoForThreeBasket.get(2)) - 1);
        }
        return totalCost;
    }

    @Override
    public Map<String, Integer> getItemCount(List<String> basket) {
        Map<String, Integer> itemCount = new HashMap<>();
        for (String item : basket) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }
        return itemCount;
    }
}
