package com.example.demo6;

import com.example.demo6.Models.Inventory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VendingMachineApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Inventory.loadInventory();
        FXMLLoader fxmlLoader = new FXMLLoader(VendingMachineApplication.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
