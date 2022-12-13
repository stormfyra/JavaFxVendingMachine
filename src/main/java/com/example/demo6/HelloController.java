package com.example.demo6;

import com.example.demo6.Models.Inventory;
import com.example.demo6.Models.Snack;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class HelloController {
    @FXML
    private Label welcomeText;

    BigDecimal inputMoney = new BigDecimal("0");
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void potatoCrispsClick() {
        String productId = "A1";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void stackersClick() {
        String productId = "A2";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void grainWavesClick() {
        String productId = "A3";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void cloudPopcornClick() {
        String productId = "A4";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void moonpieClick() {
        String productId = "B1";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void cowtalesClick() {
        String productId = "B2";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void wonkaBarClick() {
        String productId = "B3";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void crunchieClick() {
        String productId = "B4";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void colaClick() {
        String productId = "C1";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void drSaltClick() {
        String productId = "C2";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void mountainMelterClick() {
        String productId = "C3";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void heavyClick() {
        String productId = "C4";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void uChewsClick() {
        String productId = "D1";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void littleLeagueChewClick() {
        String productId = "D2";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void chicletsClick() {
        String productId = "D3";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void triplemintClick() {
        String productId = "D4";
        purchaseSelectedSnack(productId);
    }

    @FXML
    protected void feedOneDollar() {
        inputMoney = inputMoney.add(new BigDecimal("1"));
        welcomeText.setText("You have " + DECIMAL_FORMAT.format(inputMoney) + ".");
    }

    @FXML
    protected void feedFiveDollars() {
        inputMoney = inputMoney.add(new BigDecimal("5"));
        welcomeText.setText("You have " + DECIMAL_FORMAT.format(inputMoney) + ".");
    }

    @FXML
    protected void feedTenDollars() {
        inputMoney = inputMoney.add(new BigDecimal("10"));
        welcomeText.setText("You have " + DECIMAL_FORMAT.format(inputMoney) + ".");
    }

    @FXML
    protected void finishTransaction() {
        int cents = inputMoney.multiply(new BigDecimal("100")).intValue();
        int quarters = cents / 25;
        int leftoverAfterQuarters = cents % 25;
        int dimes = leftoverAfterQuarters / 10;
        int leftoverAfterDimes = leftoverAfterQuarters % 10;
        int nickels = leftoverAfterDimes / 5;
        String display = "You have been dispensed " + quarters + " quarters, " + dimes + " dimes, and " + nickels +
                " nickels.";
        welcomeText.setText(display);
        inputMoney = new BigDecimal("0");
    }

    public void purchaseSelectedSnack(String productId) {
        Snack selectedSnack = Inventory.getSnacks().get(productId);
        BigDecimal selectedSnackPrice = selectedSnack.getPrice();

        boolean selectedSnackIsSoldOut = selectedSnack.getQuantity() == 0;
        boolean inputMoneyIsNotEnoughToPurchaseSelectedSnack = selectedSnackPrice.compareTo(inputMoney) > 0;

        if (selectedSnackIsSoldOut) {
            welcomeText.setText("Sold out. You have " + DECIMAL_FORMAT.format(inputMoney) + ".");
        } else if (inputMoneyIsNotEnoughToPurchaseSelectedSnack) {
            welcomeText.setText("Insufficient funds. You have " + DECIMAL_FORMAT.format(inputMoney) + ".");
        } else {
            selectedSnack.deductSnackQuantityByOne();
            inputMoney = inputMoney.subtract(selectedSnackPrice);
            welcomeText.setText("You have purchased " + selectedSnack.getName() + " for" + " $" +
                    DECIMAL_FORMAT.format(selectedSnack.getPrice()) + ". You now have" + " $" +
                    DECIMAL_FORMAT.format(inputMoney) + ". " + selectedSnack.getMessage());
        }
    }
}
