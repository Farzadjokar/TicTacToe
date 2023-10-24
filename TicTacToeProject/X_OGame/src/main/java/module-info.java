module com.example.x_ogame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.x_ogame to javafx.fxml;
    exports com.example.x_ogame;
}