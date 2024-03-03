package com.dasalaza.passwordgeneratorwithfxml.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class UserDataController {

    @FXML
    public TextField nameInput;
    @FXML
    public TextField surnameInput;
    @FXML
    public TextField numberInput;

    public UserDataController() {
        this.setNameInput(nameInput);
        this.setSurnameInput(surnameInput);
        this.setNumberInput(numberInput);
    }

    public void setNameInput(TextField nameInput) {
        this.nameInput = nameInput;
    }

    public void setSurnameInput(TextField surnameInput) {
        this.surnameInput = surnameInput;
    }

    public void setNumberInput(TextField numberInput) {
        this.numberInput = numberInput;
    }

    public String getNameInput() {
        return nameInput.getText();
    }

    public String getSurnameInput() {
        return surnameInput.getText();
    }

    public String getNumberInput() {
        return numberInput.getText();
    }

    //    @FXML
    public void resetUserFields() {
        nameInput.clear();
        surnameInput.clear();
        numberInput.clear();
    }

    public boolean checkInputFieldsNotNull() {
        if (getNameInput().isEmpty() || getNameInput().isBlank()) {
            showTypeErrorInput("Introduce correct value in Name!");
            return false;
        } else if (getSurnameInput().isEmpty() || getSurnameInput().isBlank()) {
            showTypeErrorInput("Introduce correct value in Surname!");
            return false;
        } else if (getNumberInput().isBlank() || getNumberInput().isBlank()) {
            showTypeErrorInput("Introduce correct value in Number!");
            return false;
        } else if (getNameInput().length() < 3) {
            showTypeErrorInput("Introduce at least 3 characters!");
            return false;
        }
        return true;
    }

    public boolean checkValidFields() {
        if (!checkValidString(getNameInput())) {
            showTypeErrorInput("Introduce only alphabetic characters in NAME!");
            return false;
        } else if (!checkValidString(getSurnameInput())) {
            showTypeErrorInput("Introduce only alphabetic characters in SURNAME!");
            return false;
        } else if (!checkNumberInputIsValid()) {
            showTypeErrorInput("Introduce only numbers 0-9!");
            return false;
        }
        return true;
    }

    private void showTypeErrorInput(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error !");
//        alert.setHeaderText(titleTypeError);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean checkValidString(String str) {
        int i = 0;
        while (i < str.length()) {
            if (str.matches("^[a-zA-Z]+$"))
                return (true);
            i++;
        }
        return (false);
    }

    private boolean checkNumberInputIsValid() {
        return getNumberInput().matches("[0-9]{1}");
    }

    public String generateDNI() {
        String letters = getSevenLetters();
        String dniSevenDigits = getSevenNumbersDNI(letters);
        String dniEigthDigits = getEightNumbersDNI(dniSevenDigits);
        int dniNumber = Integer.parseInt(dniEigthDigits);
        String alphabet = "TRWAGMYFPDXBNJZSQVHLCKE";
        char dniLetter = alphabet.charAt(dniNumber % 23);
        return dniEigthDigits.concat(String.valueOf(dniLetter));
    }

    private String getSevenLetters() {
        String name = getNameInput();
        String surname = getSurnameInput();
        String result = new String(new char[7]);

        if (name.length() < 7) {
            result = name;
            int numeroLetrasFaltantes = 7 - result.length();
            String parteRestante = surname.substring(0, numeroLetrasFaltantes);
            result.concat(parteRestante);
        } else if (name.length() >= 7)
            result = name.substring(0, 7);
        return result;
    }

    private String getSevenNumbersDNI(String s) {
        StringBuilder dniNumber = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int position = s.charAt(i) - 'a';
            dniNumber.append(position % 10);
        }
        return dniNumber.toString();
    }

    // Calculo octavo numero del dni.
    private String getEightNumbersDNI(String dniSevenNumbers) {
        int dniNumber = Integer.parseInt(dniSevenNumbers);
        int multiplier = Integer.parseInt(getNumberInput());
        dniNumber = dniNumber * multiplier;
        return String.valueOf(dniNumber);
    }
}

