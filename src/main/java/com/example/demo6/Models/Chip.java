package com.example.demo6.Models;

import java.math.BigDecimal;

public class Chip extends Snack {

    public Chip(String name, BigDecimal price) {
        super(name, price);
    }

    public Chip() {
    }

    public final String getMessage() {
        return "Crunch Crunch, Yum!";
    }
}
