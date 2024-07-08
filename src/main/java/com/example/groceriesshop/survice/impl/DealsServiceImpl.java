package com.example.groceriesshop.survice.impl;

import com.example.groceriesshop.models.Products;
import com.example.groceriesshop.repository.impl.DealsRepositoryImpl;
import com.example.groceriesshop.repository.impl.ProductsRepositoryImpl;
import com.example.groceriesshop.survice.DealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealsServiceImpl implements DealsService {
    private final DealsRepositoryImpl dealsRepository;
    private final ProductsRepositoryImpl productsRepository;

    @Autowired
    public DealsServiceImpl(DealsRepositoryImpl dealsRepository, ProductsRepositoryImpl productsRepository) {
        this.dealsRepository = dealsRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public void addProductToTwoForThree(String productName) {
        Products product = productsRepository.findByName(productName);
        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + productName);
        }
        dealsRepository.addTwoForThreeItem(product);
    }

    @Override
    public void addProductToBuyOneGetOneHalfPrice(String productName) {
        Products product = productsRepository.findByName(productName);
        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + productName);
        }
        dealsRepository.addBuyOneGetOneHalfPriceItem(product);
    }

    @Override
    public List<Products> getTwoForThreeItems() {
        return dealsRepository.getTwoForThreeItems();
    }

    @Override
    public List<Products> getBuyOneGetOneHalfPriceItems() {
        return dealsRepository.getBuyOneGetOneHalfPriceItems();
    }

}
