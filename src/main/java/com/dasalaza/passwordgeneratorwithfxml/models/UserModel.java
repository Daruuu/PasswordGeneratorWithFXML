package com.dasalaza.passwordgeneratorwithfxml.models;

import javafx.scene.control.Alert;

public class UserModel {

    private String name;
    private String surname;

    public UserModel() {
    }
    public UserModel(String name, String surname) {
        this.name = name;
        this.surname = surname;
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


//    Los 8 dígitos del DNI se generarán a partir de:

    /*
    1-Las 7 primeras letras del nombre y los apellidos.
    (Ejemplo:
    */
    private void    manageInputData(){

    }

    // Si el nombre ocupa 5 letras,
    // se utilizan las 5 letras del nombre y las 2 primeras del apellido.
    private void    checkLengthName(){
        if (getName().isEmpty() || getName().isBlank())
            showTypeErrorInput("Length NAME is null", "Introduce data in this field!");
        else if (getName().length() < 5)
            showTypeErrorInput("Length NAME is short", "Introduce a name of 5 letters!");
        else if (getName().length() == 5)
        {

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
/*
        while (str.charAt(i))
        {
            if (getName().matches("^[a-zA-Z]+$"))
            {
                return (true);
                break;
            }
        }
*/
        return (false);
    }

    /*
    3-Multiplicador:
   Una vez obtenidos los 7 números se multiplicará por un número comprendido entre el 1 y el 9 (la app debe controlar que el usuario no introduzca un valor superior). El resultado obtenido nos dará los 8 dígitos de la parte nº del DNI.
     */
    private void checkFirstNumberDniValid(){

    }
}
