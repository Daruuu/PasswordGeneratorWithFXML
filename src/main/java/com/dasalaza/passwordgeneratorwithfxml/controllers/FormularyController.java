package com.dasalaza.passwordgeneratorwithfxml.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FormularyController {

    @FXML
    public Button buttonGenerateDni;

    @FXML
    public Button buttonResetFields;

    @FXML
    public TextField newDniGenerated;

    public UserDataController fieldsUserController = new UserDataController();

//    public void handleInputData() {
//        fieldsUserController.checkInputFieldsNotNull();
//    }

    @FXML
    public void    buttonResetFieldsFormulary(){
        fieldsUserController.resetUserFields();
        System.out.println(fieldsUserController.getNameInput());
        System.out.println(fieldsUserController.getSurnameInput());
        System.out.println(fieldsUserController.getNumberInput());
    }
    @FXML
    public void buttonActionGenerateDni(){
        fieldsUserController.checkInputFieldsNotNull();
        fieldsUserController.checkValidFields();
        // ALGORITMO PAR AGENERA EL DNI

        System.out.println(fieldsUserController.getNameInput());
        System.out.println(fieldsUserController.getSurnameInput());
        System.out.println(fieldsUserController.getNumberInput());
    }
}
