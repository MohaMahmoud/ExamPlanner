module examplanner {
    exports com.mohamahmoud.view;
    exports com.mohamahmoud.controller;
    exports com.mohamahmoud.model;

    opens com.mohamahmoud.controller to javafx.fxml;

    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires com.fasterxml.jackson.databind;
}
