package com.example.demo6.Models;

import java.math.BigDecimal;

public class Gum extends Snack {

    public Gum(String name, BigDecimal price) {
        super(name, price);
    }

    public Gum() {
    }

    public final String getMessage() {
        return "Chew Chew, Yum!";
    }
}
