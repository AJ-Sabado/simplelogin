module com.arvinsabado.simplelogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.arvinsabado.simplelogin to javafx.fxml;
    exports com.arvinsabado.simplelogin;
    
}
