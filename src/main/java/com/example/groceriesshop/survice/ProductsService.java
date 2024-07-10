package com.example.groceriesshop.survice;

import com.example.groceriesshop.models.Products;

import java.util.List;
import java.util.Map;

/**
 * Интерфейс, дефиниращ операции за управление на продукти в магазина.
 */
public interface ProductsService {
    /**
     * Добавя списък от продукти към магазина.
     *
     * @param productsList Списък от продукти за добавяне
     */
    void addProducts(List<Products> productsList);

    /**
     * Връща всички продукти в магазина като мап с ключ - име на продукта и стойност - цена.
     *
     * @return Мап с всички продукти в магазина
     */
    Map<String, Double> getAllProducts();

    /**
     * Изчислява общата цена на пазарската кошница спрямо текущите цени на продуктите в магазина.
     *
     * @param basket Списък с имена на продуктите в пазарската кошница
     * @return Общата цена на пазарската кошница
     */
    String calculateTotalCost(List<String> basket);

    /**
     * Изчислява цената за офертата "Купи едно, вземи едно на половин цена".
     *
     * @param products   Мап с всички продукти в магазина и техните цени
     * @param totalCost  Текущата обща цена
     * @param itemCount  Мап с броя на всяка единица продукт в пазарската кошница
     * @return Общата цена след изчисляване на офертата "Купи едно, вземи едно на половин цена"
     */
    double calculateOneForHalf(Map<String, Double> products, double totalCost, Map<String, Integer> itemCount);

    /**
     * Изчислява цената за офертата "Две за три".
     *
     * @param basket     Списък с имена на продуктите в пазарската кошница
     * @param products   Мап с всички продукти в магазина и техните цени
     * @param totalCost  Текущата обща цена
     * @param itemCount  Мап с броя на всяка единица продукт в пазарската кошница
     * @return Общата цена след изчисляване на офертата "Две за три"
     */
    double calculateTwoForThree(List<String> basket, Map<String, Double> products, double totalCost, Map<String, Integer> itemCount);

    /**
     * Връща мап с броя на всяка единица продукт в пазарската кошница.
     *
     * @param basket Списък с имена на продуктите в пазарската кошница
     * @return Мап с броя на всяка единица продукт в пазарската кошница
     */
    Map<String, Integer> getItemCount(List<String> basket);
}
