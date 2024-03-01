package com.dasalaza.passwordgeneratorwithfxml;

import com.dasalaza.passwordgeneratorwithfxml.controllers.FormularyController;
import com.dasalaza.passwordgeneratorwithfxml.controllers.UserDataController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DniGeneratorApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DniGeneratorApplication.class.getResource("formularyMainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Formulary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
