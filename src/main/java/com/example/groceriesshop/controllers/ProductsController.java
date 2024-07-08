package com.example.groceriesshop.controllers;

import com.example.groceriesshop.models.Products;
import com.example.groceriesshop.survice.impl.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsServiceImpl productService;

    @Autowired
    public ProductsController(ProductsServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping("/addProducts")
    public ResponseEntity<Map<String, Double>>addProducts(@RequestBody List<Products> products) {
        productService.addProducts(products);
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/calculateTotalPrice")
    public ResponseEntity<String> calculateTotalPrice(@RequestBody Map<String, List<String>> requestBody) {
        List<String> scannedItems = requestBody.get("scannedItems");
        String totalPrice = productService.calculateTotalCost(scannedItems);
        return ResponseEntity.ok(totalPrice);
    }
}
