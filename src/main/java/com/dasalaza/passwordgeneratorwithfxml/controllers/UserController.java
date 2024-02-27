package com.dasalaza.passwordgeneratorwithfxml.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserController {

    @FXML
    public TextField nameInput;
    @FXML
    public TextField surnameInput;
    @FXML
    public TextField numberInput;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}