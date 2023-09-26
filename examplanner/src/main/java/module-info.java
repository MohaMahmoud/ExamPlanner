module examplanner {
    exports com.mohamahmoud.view;
    exports com.mohamahmoud.controller;
    exports com.mohamahmoud.model.academic;
    exports com.mohamahmoud.model.grading;

    exports com.mohamahmoud.data to com.fasterxml.jackson.databind;

    opens com.mohamahmoud.data to com.fasterxml.jackson.databind;
    opens com.mohamahmoud.model.academic to com.fasterxml.jackson.databind;
    opens com.mohamahmoud.model.grading to com.fasterxml.jackson.databind;
    opens com.mohamahmoud.controller to javafx.fxml;

    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires com.fasterxml.jackson.databind;
}
