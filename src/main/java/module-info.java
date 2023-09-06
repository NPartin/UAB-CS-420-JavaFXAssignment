module com.example.uabcs420javafxassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uabcs420javafxassignment to javafx.fxml;
    exports com.example.uabcs420javafxassignment;
}