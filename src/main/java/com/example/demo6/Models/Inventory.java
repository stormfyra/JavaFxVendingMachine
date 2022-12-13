package com.example.demo6.Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private static final Map<String, Snack> snacks = new LinkedHashMap<>();

    public static Map<String, Snack> getSnacks() {
        return snacks;
    }

    public static void loadInventory() {
        File file = new File(
                "C:\\Users\\Student\\workspace\\storm-sternberg-student-code\\module-2\\16_Securing_APIs" +
                        "\\exercise\\demo6\\src\\main\\resources\\com\\example\\demo6\\vendingmachine.csv");
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] snackInformation = line.split("\\|");

                String productId = snackInformation[0];
                String name = snackInformation[1];
                BigDecimal price = new BigDecimal(snackInformation[2]);
                String snackType = snackInformation[3];

                Snack snack;
                switch (snackType) {
                    case "Candy":
                        snack = new Candy(productId, name, price);
                        break;
                    case "Chip":
                        snack = new Chip(productId, name, price);
                        break;
                    case "Drink":
                        snack = new Drink(productId, name, price);
                        break;
                    default:
                        snack = new Gum(productId, name, price);
                        break;
                }
                snacks.put(productId, snack);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
