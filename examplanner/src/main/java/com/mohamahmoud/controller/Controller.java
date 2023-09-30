package com.mohamahmoud.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mohamahmoud.data.Data;
import com.mohamahmoud.data.DataStorage;
import com.mohamahmoud.model.academic.Exam;
import com.mohamahmoud.model.academic.Semester;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller implements Initializable {
    private Semester currentSemester;
    @FXML
    private ComboBox<Semester> semesterSelection;
    @FXML
    private TableView<Exam> examsTable;
    @FXML
    private TableColumn<Exam, String> dateColumn;
    @FXML
    private TableColumn<Exam, String> nameColumn;
    @FXML
    private TableColumn<Exam, String> ectsColumn;
    @FXML
    private TableColumn<Exam, String> stateColumn;
    @FXML
    private TableColumn<Exam, String> gradeColumn;
    @FXML
    private TableColumn<Exam, String> scoreColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Read the data from the data storage.
        DataStorage storage = new DataStorage();
        Data data = null;
        try {
            data = storage.readData();
        } catch (IOException exception) {
            // TODO: handle exception
            return;
        }

        // Display the previously saved content.
        currentSemester = data.getCurrentSemester();
        switchSemester(currentSemester);
        semesterSelection.setItems(FXCollections.observableList(data.getSemesters()));
        semesterSelection.setValue(currentSemester);

        // Action handler for the semester switch.
        semesterSelection.setOnAction(actionEvent -> {
            Semester selectedSemester = semesterSelection.getValue();
            switchSemester(selectedSemester);
        });
    }

    private void switchSemester(Semester semester) {
        currentSemester = semester;

        // Display the new content and save in data storage.
        displayContent();
        save();
    }

    private void displayContent() {
        examsTable.setItems(FXCollections.observableArrayList(currentSemester.getExams()));
    }

    private void save() {
        DataStorage dataStorage = new DataStorage();
        Data data = new Data(semesterSelection.getItems(), currentSemester);

        try {
            dataStorage.saveData(data);
        } catch (IOException exception) {
            exception.printStackTrace();
            // TODO Handle the exception
        }
    }

}
