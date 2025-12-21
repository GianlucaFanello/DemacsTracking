module org.example.demacstracking {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.demacstracking to javafx.fxml;
    exports org.example.demacstracking;
}