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

    @FXML
    public void    buttonResetFieldsFormulary(){
        fieldsUserController.resetUserFields();
    }
    @FXML
    public void buttonActionGenerateDni(){
        boolean fieldsNotNull = fieldsUserController.checkInputFieldsNotNull();
        boolean validFields = fieldsUserController.checkValidFields();

        if (fieldsNotNull && validFields) {
            String dni = fieldsUserController.generateDNI();
            newDniGenerated.setText(dni);
        }
    }
}
