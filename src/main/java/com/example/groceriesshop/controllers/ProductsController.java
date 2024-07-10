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

/**
 * ProductsController е REST контролер, който управлява операциите свързани с продуктите в магазина за хранителни стоки.
 *
 * <p>Този контролер предоставя два основни края на точки:</p>
 * <ul>
 *   <li>Добавяне на продукти</li>
 *   <li>Изчисляване на общата цена на сканирани продукти</li>
 * </ul>
 */
@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsServiceImpl productService;

    /**
     * Конструктор за ProductsController.
     *
     * @param productService инстанция на ProductsServiceImpl, която се използва за управление на продуктите
     */
    @Autowired
    public ProductsController(ProductsServiceImpl productService) {
        this.productService = productService;
    }


    /**
     * Добавя списък с продукти в системата.
     *
     * @param products Списък с продукти за добавяне
     * @return ResponseEntity, съдържащо актуализирания списък с всички продукти и техните цени
     */
    @PostMapping("/addProducts")
    public ResponseEntity<Map<String, Double>>addProducts(@RequestBody List<Products> products) {
        productService.addProducts(products);
        return ResponseEntity.ok(productService.getAllProducts());
    }


    /**
     * Изчислява общата цена на сканирани продукти.
     *
     * @param requestBody Карта съдържаща списък със сканирани продукти
     * @return ResponseEntity, съдържащо общата цена на сканираните продукти
     */
    @PostMapping("/calculateTotalPrice")
    public ResponseEntity<String> calculateTotalPrice(@RequestBody Map<String, List<String>> requestBody) {
        List<String> scannedItems = requestBody.get("scannedItems");
        String totalPrice = productService.calculateTotalCost(scannedItems);
        return ResponseEntity.ok(totalPrice);
    }
}
