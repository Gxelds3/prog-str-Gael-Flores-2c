module com.example.praciticaexamne {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.praciticaexamne to javafx.fxml;
    opens  com.example.praciticaexamne.Contacto to javafx.fxml;
    opens  com.example.praciticaexamne.Controller to javafx.fxml;
    opens  com.example.praciticaexamne.validaciones to javafx.fxml;
    exports com.example.praciticaexamne;
    exports com.example.praciticaexamne.Contacto;
    exports com.example.praciticaexamne.Controller;
    exports com.example.praciticaexamne.validaciones;
}