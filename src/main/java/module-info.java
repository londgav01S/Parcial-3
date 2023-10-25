module com.example.parcial3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;


    opens com.example.parcial3 to javafx.fxml;
    exports com.example.parcial3;
}