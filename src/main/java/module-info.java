module com.dasalaza.passwordgeneratorwithfxml {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.dasalaza.passwordgeneratorwithfxml to javafx.fxml;
    exports com.dasalaza.passwordgeneratorwithfxml;
    exports com.dasalaza.passwordgeneratorwithfxml.controllers;
    opens com.dasalaza.passwordgeneratorwithfxml.controllers to javafx.fxml;
    exports com.dasalaza.passwordgeneratorwithfxml.models;
    opens com.dasalaza.passwordgeneratorwithfxml.models to javafx.fxml;
}