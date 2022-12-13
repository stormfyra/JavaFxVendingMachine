package com.example.demo6.Models;

import java.math.BigDecimal;

public class Candy extends Snack {

    public Candy(String name, BigDecimal price) {
        super(name, price);
    }

    public Candy() {
    }

    public final String getMessage() {
        return "Munch Munch, Yum!";
    }
}
