package com.example.demo6.Models;

import java.math.BigDecimal;

public abstract class Snack {
    private String name;
    private BigDecimal price;
    private int quantity = 5;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Snack(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Snack() {

    }

    public final void deductSnackQuantityByOne() {
        quantity--;
    }

    public abstract String getMessage();
}
