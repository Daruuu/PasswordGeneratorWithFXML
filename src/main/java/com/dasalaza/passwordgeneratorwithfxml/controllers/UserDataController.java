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
    TextField empty = new TextField("");

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

    public void checkInputFieldsNotNull() {
        if (getNameInput().isEmpty() || getNameInput().isBlank())
            showTypeErrorInput("Introduce correct value in Name!");
        else if (getSurnameInput().isEmpty() || getSurnameInput().isBlank())
            showTypeErrorInput("Introduce correct value in Surname!");
        else if (getNumberInput().isBlank() || getNumberInput().isBlank())
            showTypeErrorInput("Introduce correct value in Number!");
        else if (getNameInput().length() < 5)
            showTypeErrorInput("Introduce at least 5 characters!");
    }

    public void checkValidFields() {
        if (!checkValidString(getNameInput()))
            showTypeErrorInput("Introduce only alphabetic characters in NAME!");
        else if (!checkValidString(getSurnameInput()))
            showTypeErrorInput("Introduce only alphabetic characters in SURNAME!");
        else if (!checkNumberInputIsValid())
            showTypeErrorInput("Introduce only numbers 0-9!");
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
    private boolean checkNumberInputIsValid(){
        return getNumberInput().matches("[0-9]{1}");
    }

    public String generateDNI()
    {
        String letters = getSevenLetters();
        int[] lettersPositions = getAlphabetPositions(letters);
        int[] dniSevenDigits = getSevenNumbersDNI(lettersPositions);
        String dniEigthDigits = getEightNumbersDNI(dniSevenDigits);
        int dniNumber = Integer.parseInt(dniEigthDigits);
        String alfabetoMinisterioInterior = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letraDni = alfabetoMinisterioInterior.charAt(dniNumber%23);
        String dniFinal = dniEigthDigits.concat(String.valueOf(letraDni));
        return dniFinal;
    }

    private String getSevenLetters(){
       String name = getNameInput();
       String surname = getSurnameInput();
       String result = new String(new char[7]);

       if (name.length() < 7)
       {
           result = name;
           int numeroLetrasFaltantes = 7 - result.length();
           String parteRestante = surname.substring(0,numeroLetrasFaltantes);
           result.concat(parteRestante);
       }
       else if (name.length() >= 7)
           result = name.substring(0, 7);
        return result;
    }

    private int[] getAlphabetPositions(String s)
    {
        int[] sevenLettersPositions = new int[7];
        for (int i = 0; i < s.length(); ++i) {
            sevenLettersPositions[i] = s.charAt(i) - 'a';
        }
        return sevenLettersPositions;
    }

    private int[] getSevenNumbersDNI(int[] sevenLettersPositions) {
        int[] dniNumber = new int[sevenLettersPositions.length];
        for (int i = 0; i < sevenLettersPositions.length; i++) {
            dniNumber[i] = sevenLettersPositions[i] % 10;
        }
        return dniNumber;
    }

    // Calculo octavo numero del dni.
    private String getEightNumbersDNI(int[] dni) {
        int dniNumber = 0;

        for (int i = dni.length-1; i > 0; i++) {
            dniNumber += (int) (dni[i] * Math.pow(10, i));
        }
        int multiplier = Integer.parseInt(getNumberInput());
        dniNumber = dniNumber * multiplier;

        String dniEigthDigits = String.valueOf(dniNumber);
        return dniEigthDigits;
    }
}

