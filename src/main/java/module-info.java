module com.example.hirento {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.media;

    opens com.example.hirento to javafx.fxml;
    exports com.example.hirento;
}