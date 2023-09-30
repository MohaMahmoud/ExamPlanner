package com.mohamahmoud.view;

import java.util.Objects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class of the Exam Planner.
 * 
 * @author Mohammad Mahmoud
 * @version 1.0
 */
public class Main extends Application {

    /**
     * Main entry point to the Exam Planner.
     * 
     * @param args The command line arguments (not used in this program)
     */
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Get resource files.
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/sample.fxml")));
        String css = Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm();

        // Set up scene.
        Scene scene = new Scene(root, 1200, 800); // TODO Width is okay but maybe change height.
        scene.getStylesheets().add(css);

        // Set up stage.
        stage.setTitle("KIT Prüfungsplaner");
        stage.setScene(scene);
        stage.show();
    }
}
