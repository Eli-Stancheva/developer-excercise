package com.example.groceriesshop.controllers;

import com.example.groceriesshop.models.Products;
import com.example.groceriesshop.survice.impl.DealsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deals")
public class DealsController {
    private final DealsServiceImpl dealService;

    @Autowired
    public DealsController(DealsServiceImpl dealService) {
        this.dealService = dealService;
    }

    @PostMapping("/addToTwoForThreeOffer")
    public ResponseEntity<List<Products>> addToTwoForThreeOffer(@RequestBody List<Products> productsList) {
        for (Products product : productsList) {
            dealService.addProductToTwoForThree(product.getName());
        }
        return ResponseEntity.ok(dealService.getTwoForThreeItems());
    }

    @PostMapping("/addToBuyOneGetOneHalfPriceOffer")
    public ResponseEntity<List<Products>> addToBuyOneGetOneHalfPriceOffer(@RequestBody List<Products> productsList) {
        for (Products product : productsList) {
            dealService.addProductToBuyOneGetOneHalfPrice(product.getName());
        }
        return ResponseEntity.ok(dealService.getBuyOneGetOneHalfPriceItems());
    }
}
