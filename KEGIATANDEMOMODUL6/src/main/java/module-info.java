module org.example.demomodul6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demomodul6 to javafx.fxml;
    exports org.example.demomodul6;
}