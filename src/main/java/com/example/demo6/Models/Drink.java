package com.example.demo6.Models;

import java.math.BigDecimal;

public class Drink extends Snack {

    public Drink(String name, BigDecimal price) {
        super(name, price);
    }

    public Drink() {
    }

    public final String getMessage() {
        return "Glug Glug, Yum!";
    }
}
