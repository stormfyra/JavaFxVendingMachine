package com.example.demo6;

import com.example.demo6.Models.Inventory;
import com.example.demo6.Models.Snack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Controller {
    @FXML
    private Label displayText;

    BigDecimal inputMoney = new BigDecimal("0");
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    @FXML
    protected void feedMoney(ActionEvent event) {
        String buttonText = ((Button)event.getSource()).getText();
        String[] buttonTextArray = buttonText.split("\\$");
        String moneyFed = buttonTextArray[1];
        inputMoney = inputMoney.add(new BigDecimal(moneyFed));
        displayText.setText("You have " + DECIMAL_FORMAT.format(inputMoney) + ".");
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
        displayText.setText(display);
        inputMoney = new BigDecimal("0");
    }

    @FXML
    protected void purchaseSelectedSnack(ActionEvent event) {
        String snackName = ((Button)event.getSource()).getText();
        Snack selectedSnack = Inventory.getSnacks().get(snackName);
        BigDecimal selectedSnackPrice = selectedSnack.getPrice();

        boolean selectedSnackIsSoldOut = selectedSnack.getQuantity() == 0;
        boolean inputMoneyIsNotEnoughToPurchaseSelectedSnack = selectedSnackPrice.compareTo(inputMoney) > 0;

        if (selectedSnackIsSoldOut) {
            displayText.setText("Sold out. You have " + DECIMAL_FORMAT.format(inputMoney) + ".");
        } else if (inputMoneyIsNotEnoughToPurchaseSelectedSnack) {
            displayText.setText("Insufficient funds. You have " + DECIMAL_FORMAT.format(inputMoney) + ".");
        } else {
            selectedSnack.deductSnackQuantityByOne();
            inputMoney = inputMoney.subtract(selectedSnackPrice);
            displayText.setText("You have purchased " + selectedSnack.getName() + " for" + " $" +
                    DECIMAL_FORMAT.format(selectedSnack.getPrice()) + ". You now have" + " $" +
                    DECIMAL_FORMAT.format(inputMoney) + ". " + selectedSnack.getMessage());
        }
    }
}
