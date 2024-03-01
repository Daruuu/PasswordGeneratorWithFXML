package com.dasalaza.passwordgeneratorwithfxml.models;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class UserModel {

    private String name;
    private String surname;
    private String number;

    public UserModel() {
    }

    public UserModel(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

//    Los 8 dígitos del DNI se generarán a partir de:
    /*
    1- Las 7 primeras letras del nombre y los apellidos.
    (Ejemplo:
    */
    private void    manageInputData(){

    }

    // Si el nombre ocupa 5 letras,
    // se utilizan las 5 letras del nombre y las 2 primeras del apellido.
    private void    checkLengthString(){
        if (getName().isEmpty() || getName().isBlank())
            showTypeErrorInput("Length NAME is null", "Introduce data in this field!");
        else if (getName().length() < 5)
            showTypeErrorInput("Length NAME is short", "Introduce a name of minim of 5 letters!");
        else if (getName().length() == 5)
        {
            String getTwoCharactersSurname = getSurname().substring(0,2);
            String concatNameAndSurname = getName().concat(getTwoCharactersSurname);
        }
        else if (getName().length() > 7)
        {
//            Si el nombre ya supera las 7 letras, no será necesario utilizar el apellido).
            /* TODO: CALL FUNCTION OF GENERATE DNI */
        }
    }

    private void    showTypeErrorInput(String titleTypeError ,String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error !");
        alert.setHeaderText(titleTypeError);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean checkValidString(String str){
        int i = 0;
        while (i < str.length())
        {
            if (str.matches("^[a-zA-Z]+$"))
                return (true);
            i++;
        }
        return (false);
    }

    /*
    3-Multiplicador:
    Una vez obtenidos los 7 números se multiplicará por un número
    comprendido entre el 1 y el 9
    (la app debe controlar que el usuario no introduzca un valor superior).
    El resultado obtenido nos dará los 8 dígitos de la parte nº del DNI.
     */

    private void    checkFirstNumberDniValid(){

    }

    // comprobar que todos los campos no sean nulos
    private boolean checkAllInputNotEmpty(){
        return getName().isEmpty() || getSurname().isEmpty() || getNumber().isBlank();
    }

    @FXML
    public void    resetFieldsUser(){
    }

}
