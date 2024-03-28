module com.example.demodsadasda {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.demodsadasda to javafx.fxml;
    exports com.example.demodsadasda;
}