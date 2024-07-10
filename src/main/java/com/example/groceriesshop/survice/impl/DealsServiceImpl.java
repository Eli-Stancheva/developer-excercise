package com.example.groceriesshop.survice.impl;

import com.example.groceriesshop.models.Products;
import com.example.groceriesshop.repository.impl.DealsRepositoryImpl;
import com.example.groceriesshop.repository.impl.ProductsRepositoryImpl;
import com.example.groceriesshop.survice.DealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервизен клас за управление на сделки в магазина.
 * Имплементира интерфейса {@link DealsService}.
 */
@Service
public class DealsServiceImpl implements DealsService {
    private final DealsRepositoryImpl dealsRepository;
    private final ProductsRepositoryImpl productsRepository;

    /**
     * Конструктор за инжектиране на зависимости.
     *
     * @param dealsRepository Репозитори за сделки
     * @param productsRepository Репозитори за продукти
     */
    @Autowired
    public DealsServiceImpl(DealsRepositoryImpl dealsRepository, ProductsRepositoryImpl productsRepository) {
        this.dealsRepository = dealsRepository;
        this.productsRepository = productsRepository;
    }

    /**
     * Добавя продукт към сделката "Две за три" по име на продукта.
     *
     * @param productName Името на продукта
     * @throws IllegalArgumentException Ако продуктът не е намерен
     */
    @Override
    public void addProductToTwoForThree(String productName) {
        Products product = productsRepository.findByName(productName);
        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + productName);
        }
        dealsRepository.addTwoForThreeItem(product);
    }

    /**
     * Добавя продукт към сделката "Купи едно, получи едно на половин цена" по име на продукта.
     *
     * @param productName Името на продукта
     * @throws IllegalArgumentException Ако продуктът не е намерен
     */
    @Override
    public void addProductToBuyOneGetOneHalfPrice(String productName) {
        Products product = productsRepository.findByName(productName);
        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + productName);
        }
        dealsRepository.addBuyOneGetOneHalfPriceItem(product);
    }

    /**
     * Връща списък с продукти за сделката "Две за три".
     *
     * @return Списък с продукти
     */
    @Override
    public List<Products> getTwoForThreeItems() {
        return dealsRepository.getTwoForThreeItems();
    }

    /**
     * Връща списък с продукти за сделката "Купи едно, получи едно на половин цена".
     *
     * @return Списък с продукти
     */
    @Override
    public List<Products> getBuyOneGetOneHalfPriceItems() {
        return dealsRepository.getBuyOneGetOneHalfPriceItems();
    }
}
