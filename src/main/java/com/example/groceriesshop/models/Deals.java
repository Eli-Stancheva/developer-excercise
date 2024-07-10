package com.example.groceriesshop.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Deals представлява клас за управление на промоционални оферти в магазина за хранителни стоки.
 *
 * <p>Този клас поддържа две основни промоционални оферти:</p>
 * <ul>
 *   <li>Две за три - два продукта на цената на три</li>
 *   <li>Купи едно, вземи едно на половин цена</li>
 * </ul>
 */
public class Deals {

    private final List<Products> twoForThreeItems = new ArrayList<>();
    private final List<Products> buyOneGetOneHalfPriceItems = new ArrayList<>();

    /**
     * Връща списък с продукти, включени в офертата "Две за три".
     *
     * @return Списък с продукти в офертата "Две за три"
     */
    public List<Products> getTwoForThreeItems() {
        return twoForThreeItems;
    }

    /**
     * Връща списък с продукти, включени в офертата "Купи едно, вземи едно на половин цена".
     *
     * @return Списък с продукти в офертата "Купи едно, вземи едно на половин цена"
     */
    public List<Products> getBuyOneGetOneHalfPriceItems() {
        return buyOneGetOneHalfPriceItems;
    }
}
