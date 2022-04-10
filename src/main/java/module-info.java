module com.example.cpsc233w22_demo3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cpsc233w22_demo3 to javafx.fxml;
    exports com.example.cpsc233w22_demo3;
}