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

/**
 *
 * <p>Този контролер предоставя два основни края на точки:</p>
 * <ul>
 *   <li>Добавяне на продукти към промоция "Две за три"</li>
 *   <li>Добавяне на продукти към промоция "Купи едно, вземи едно на половин цена"</li>
 * </ul>
 */
@RestController
@RequestMapping("/deals")
public class DealsController {
    private final DealsServiceImpl dealService;

    /**
     * Конструктор за DealsController.
     *
     * @param dealService инстанция на DealsServiceImpl, която се използва за управление на сделките
     */
    @Autowired
    public DealsController(DealsServiceImpl dealService) {
        this.dealService = dealService;
    }

    /**
     * Добавя списък с продукти към промоцията "Две за три".
     *
     * @param productsList Списък с продукти за добавяне към промоцията
     * @return ResponseEntity, съдържащо актуализирания списък с продукти в промоцията
     */
    @PostMapping("/addToTwoForThreeOffer")
    public ResponseEntity<List<Products>> addToTwoForThreeOffer(@RequestBody List<Products> productsList) {
        for (Products product : productsList) {
            dealService.addProductToTwoForThree(product.getName());
        }
        return ResponseEntity.ok(dealService.getTwoForThreeItems());
    }

    /**
     * Добавя списък с продукти към промоцията "Купи едно, вземи едно на половин цена".
     *
     * @param productsList Списък с продукти за добавяне към промоцията
     * @return ResponseEntity, съдържащо актуализирания списък с продукти в промоцията
     */
    @PostMapping("/addToBuyOneGetOneHalfPriceOffer")
    public ResponseEntity<List<Products>> addToBuyOneGetOneHalfPriceOffer(@RequestBody List<Products> productsList) {
        for (Products product : productsList) {
            dealService.addProductToBuyOneGetOneHalfPrice(product.getName());
        }
        return ResponseEntity.ok(dealService.getBuyOneGetOneHalfPriceItems());
    }
}
