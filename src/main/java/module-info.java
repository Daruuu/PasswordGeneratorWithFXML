module com.dasalaza.passwordgeneratorwithfxml {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.dasalaza.passwordgeneratorwithfxml to javafx.fxml;
    exports com.dasalaza.passwordgeneratorwithfxml;
}