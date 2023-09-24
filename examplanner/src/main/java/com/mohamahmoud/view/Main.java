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
        System.out.println( "Hello World!" );
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/sample.fxml")));
        stage.setTitle("KIT Prüfungsplaner");
        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    }
}
