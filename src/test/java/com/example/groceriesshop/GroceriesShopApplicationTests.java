package com.example.groceriesshop;

import com.example.groceriesshop.models.Products;
import com.example.groceriesshop.repository.impl.DealsRepositoryImpl;
import com.example.groceriesshop.repository.impl.ProductsRepositoryImpl;
import com.example.groceriesshop.survice.impl.DealsServiceImpl;
import com.example.groceriesshop.survice.impl.ProductsServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class GroceriesShopApplicationTests {
    private ProductsServiceImpl productsService;
    private DealsServiceImpl dealsService;

    @Before
    public void setUp() {
        ProductsRepositoryImpl productsRepository = new ProductsRepositoryImpl();
        DealsRepositoryImpl dealsRepository = new DealsRepositoryImpl();

        productsService = new ProductsServiceImpl(productsRepository, dealsRepository);
        dealsService = new DealsServiceImpl(dealsRepository, productsRepository);
    }

    @Test
    public void testCalculateTotalCost() {
        Products apple = new Products("apple", 50.0);
        Products banana = new Products("banana", 40.0);
        Products tomato = new Products("tomato", 30.0);
        Products potato = new Products("potato", 26.0);

        List<Products> productsList = Arrays.asList(apple, banana, tomato, potato);
        productsService.addProducts(productsList);

        dealsService.addProductToTwoForThree("apple");
        dealsService.addProductToTwoForThree("banana");
        dealsService.addProductToTwoForThree("tomato");
        dealsService.addProductToBuyOneGetOneHalfPrice("potato");

        List<String> basket = Arrays.asList("apple", "banana", "banana", "potato", "tomato", "banana", "potato");

        String totalCost = productsService.calculateTotalCost(basket);
        Assert.assertEquals("1 aws and 99 clouds", totalCost);
    }

    @Test
    public void testCalculateTotalCost2() {
        Products apple = new Products("apple", 50.0);
        Products banana = new Products("banana", 40.0);
        Products tomato = new Products("tomato", 30.0);
        Products potato = new Products("potato", 26.0);
        Products cucumber = new Products("cucumber", 15.0);
        Products peach = new Products("peach", 10.0);
        Products chery = new Products("chery", 35.0);

        List<Products> productsList = Arrays.asList(apple, banana, tomato, potato, cucumber, peach, chery);
        productsService.addProducts(productsList);

        dealsService.addProductToTwoForThree("banana");
        dealsService.addProductToTwoForThree("tomato");
        dealsService.addProductToTwoForThree("cucumber");
        dealsService.addProductToBuyOneGetOneHalfPrice("chery");

        List<String> basket = Arrays.asList("apple", "cucumber", "chery", "potato", "tomato", "chery", "chery", "chery");

        String totalCost = productsService.calculateTotalCost(basket);
        Assert.assertEquals("2 aws and 26 clouds", totalCost);
    }

    @Test
    public void testCalculateTotalCostWithoutReachingADiscount() {
        Products apple = new Products("apple", 50.0);
        Products banana = new Products("banana", 40.0);
        Products tomato = new Products("tomato", 30.0);
        Products potato = new Products("potato", 26.0);
        Products cucumber = new Products("cucumber", 15.0);

        List<Products> productsList = Arrays.asList(apple, banana, tomato, potato, cucumber);
        productsService.addProducts(productsList);

        dealsService.addProductToTwoForThree("apple");
        dealsService.addProductToTwoForThree("banana");
        dealsService.addProductToTwoForThree("tomato");
        dealsService.addProductToBuyOneGetOneHalfPrice("potato");

        List<String> basket = Arrays.asList("apple", "cucumber", "potato", "tomato");

        String totalCost = productsService.calculateTotalCost(basket);
        Assert.assertEquals("1 aws and 21 clouds", totalCost);
    }

    @Test
    public void testShouldReachingOnlyBuyOneGetOneHalfPriceDeal() {
        Products apple = new Products("apple", 50.0);
        Products banana = new Products("banana", 40.0);
        Products tomato = new Products("tomato", 30.0);
        Products potato = new Products("potato", 26.0);
        Products cucumber = new Products("cucumber", 15.0);

        List<Products> productsList = Arrays.asList(apple, banana, tomato, potato, cucumber);
        productsService.addProducts(productsList);

        dealsService.addProductToTwoForThree("apple");
        dealsService.addProductToTwoForThree("banana");
        dealsService.addProductToTwoForThree("tomato");
        dealsService.addProductToBuyOneGetOneHalfPrice("potato");

        List<String> basket = Arrays.asList("apple", "cucumber", "potato", "tomato", "potato");

        String totalCost = productsService.calculateTotalCost(basket);
        Assert.assertEquals("1 aws and 34 clouds", totalCost);
    }

    @Test
    public void testShouldReachingOnlyTwoForThreeDeal() {
        Products apple = new Products("apple", 50.0);
        Products banana = new Products("banana", 40.0);
        Products tomato = new Products("tomato", 30.0);
        Products potato = new Products("potato", 26.0);
        Products cucumber = new Products("cucumber", 15.0);

        List<Products> productsList = Arrays.asList(apple, banana, tomato, potato, cucumber);
        productsService.addProducts(productsList);

        dealsService.addProductToTwoForThree("apple");
        dealsService.addProductToTwoForThree("banana");
        dealsService.addProductToTwoForThree("tomato");
        dealsService.addProductToBuyOneGetOneHalfPrice("potato");

        List<String> basket = Arrays.asList("apple", "cucumber", "potato", "tomato", "banana");

        String totalCost = productsService.calculateTotalCost(basket);
        Assert.assertEquals("1 aws and 31 clouds", totalCost);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TwoForThreeDealShouldThrowIllegalArgumentExceptionForAddingForthElement() {
        Products apple = new Products("apple", 50.0);
        Products banana = new Products("banana", 40.0);
        Products tomato = new Products("tomato", 30.0);
        Products potato = new Products("potato", 26.0);
        Products cucumber = new Products("cucumber", 15.0);

        List<Products> productsList = Arrays.asList(apple, banana, tomato, potato,cucumber);
        productsService.addProducts(productsList);

        dealsService.addProductToTwoForThree("banana");
        dealsService.addProductToTwoForThree("tomato");
        dealsService.addProductToTwoForThree("cucumber");
        dealsService.addProductToTwoForThree("potato");
        dealsService.addProductToBuyOneGetOneHalfPrice("apple");
    }

    @Test(expected = IllegalArgumentException.class)
    public void OneAndHalfDealShouldThrowIllegalArgumentExceptionForAddingForthElement() {
        Products apple = new Products("apple", 50.0);
        Products banana = new Products("banana", 40.0);
        Products tomato = new Products("tomato", 30.0);
        Products potato = new Products("potato", 26.0);
        Products cucumber = new Products("cucumber", 15.0);

        List<Products> productsList = Arrays.asList(apple, banana, tomato, potato,cucumber);
        productsService.addProducts(productsList);

        dealsService.addProductToTwoForThree("banana");
        dealsService.addProductToTwoForThree("tomato");
        dealsService.addProductToTwoForThree("potato");
        dealsService.addProductToBuyOneGetOneHalfPrice("apple");
        dealsService.addProductToBuyOneGetOneHalfPrice("potato");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIllegalArgumentExceptionForAddingElementWhichDoesNotExistForBuyOneGetOneHalfPriceDeal() {
        Products apple = new Products("apple", 50.0);
        Products banana = new Products("banana", 40.0);
        Products tomato = new Products("tomato", 30.0);
        Products potato = new Products("potato", 26.0);
        Products cucumber = new Products("cucumber", 15.0);

        List<Products> productsList = Arrays.asList(apple, banana, tomato, potato,cucumber);
        productsService.addProducts(productsList);

        dealsService.addProductToTwoForThree("banana");
        dealsService.addProductToTwoForThree("tomato");
        dealsService.addProductToTwoForThree("potato");
        dealsService.addProductToBuyOneGetOneHalfPrice("chery");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIllegalArgumentExceptionForAddingElementWhichDoesNotExistForTwoForThreeDeal() {
        Products apple = new Products("apple", 50.0);
        Products banana = new Products("banana", 40.0);
        Products tomato = new Products("tomato", 30.0);
        Products potato = new Products("potato", 26.0);
        Products cucumber = new Products("cucumber", 15.0);

        List<Products> productsList = Arrays.asList(apple, banana, tomato, potato,cucumber);
        productsService.addProducts(productsList);

        dealsService.addProductToTwoForThree("banana");
        dealsService.addProductToTwoForThree("tomato");
        dealsService.addProductToTwoForThree("chery");
        dealsService.addProductToBuyOneGetOneHalfPrice("potato");

    }
}

