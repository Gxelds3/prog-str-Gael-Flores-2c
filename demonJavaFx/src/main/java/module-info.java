module com.example.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demonjavafx.controles to javafx.fxml;
    exports com.example.demonjavafx.controles;

    opens com.example.demonjavafx to javafx.fxml;
    exports com.example.demonjavafx;
}