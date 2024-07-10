package com.example.groceriesshop.models;

/**
 * Класът Products представлява продукт в магазина за хранителни стоки.
 * <p>
 * Този клас съдържа информация за името и цената на продукта.
 */
public class Products {
    private String name;
    private Double price;

    /**
     * Конструктор по подразбиране.
     */
    public Products() {}

    /**
     * Конструктор с параметри за създаване на продукт.
     *
     * @param name  Името на продукта
     * @param price Цената на продукта
     */
    public Products(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Връща името на продукта.
     *
     * @return Името на продукта
     */
    public String getName() {
        return name;
    }

    /**
     * Задава името на продукта.
     *
     * @param name Името на продукта
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Връща цената на продукта.
     *
     * @return Цената на продукта
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Задава цената на продукта.
     *
     * @param price Цената на продукта
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}
