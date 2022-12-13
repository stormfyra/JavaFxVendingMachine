package com.example.demo6.Models;

import java.math.BigDecimal;

public class Gum extends Snack {

    public Gum(String productId, String name, BigDecimal price) {
        super(productId, name, price);
    }

    public Gum() {
    }

    public final String getMessage() {
        return "Chew Chew, Yum!";
    }
}
