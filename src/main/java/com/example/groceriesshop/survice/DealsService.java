package com.example.groceriesshop.survice;

import com.example.groceriesshop.models.Products;

import java.util.List;

/**
 * Интерфейс, който дефинира операции за управление на различни оферти в магазина.
 */
public interface DealsService {
    /**
     * Добавя продукт към офертата "Две за три".
     *
     * @param productName Име на продукта, който да се добави
     */
    void addProductToTwoForThree(String productName);

    /**
     * Добавя продукт към офертата "Купи едно, вземи едно на половин цена".
     *
     * @param productName Име на продукта, който да се добави
     */
    void addProductToBuyOneGetOneHalfPrice(String productName);

    /**
     * Връща списък с продуктите, които са включени в офертата "Две за три".
     *
     * @return Списък с продукти за офертата "Две за три"
     */
    List<Products> getTwoForThreeItems();

    /**
     * Връща списък с продуктите, които са включени в офертата "Купи едно, вземи едно на половин цена".
     *
     * @return Списък с продукти за офертата "Купи едно, вземи едно на половин цена"
     */
    List<Products> getBuyOneGetOneHalfPriceItems();
}
