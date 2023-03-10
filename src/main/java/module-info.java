module com.example.gui_project_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gui_project_3 to javafx.fxml;
    exports com.example.gui_project_3;
}