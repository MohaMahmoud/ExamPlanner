package com.mohamahmoud.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.mohamahmoud.model.Semester;

/**
 * This class tests the {@link DataStorage} class.
 * 
 * @author Mohammad Mahmoud
 * @version 1.0
 */
public class DataStorageTest {
    private static final String USERDATA_PATH = "userdata.json";
    private static final String TEMP_PATH = "json/temp.json";
    private static final String INVALID_PATH = "json/invalid.json";

    private DataStorage storage;
    private SemesterData data;

    @BeforeEach
    public void setup() {
        // Initiate data storage.
        storage = new DataStorage();
        // Initiate semester data.
        Semester semester1 = new Semester("Wintersemester 2022/23");
        Semester semester2 = new Semester("Sommersemester 2023");
        data = new SemesterData(List.of(semester1, semester2), semester1);
    }

    @Test
    public void testSaveAndReadData() {
        // Test the saving of the data.
        try {
            storage.saveData(data, USERDATA_PATH);
        } catch (IOException exception) {
            Assertions.fail("Exception thrown while saving the data: " + exception.getMessage());
        }
        // Test the reading of the data.
        try {
            SemesterData retrievedData = storage.readData(USERDATA_PATH);

            // Assert that the retrieved data matches the original data.
            Assertions.assertEquals(data, retrievedData);
        } catch (IOException exception) {
            Assertions.fail("Exception thrown while reading the data: " + exception.getMessage());
        }
    }

    @Test
    public void testFileNotFound() {
        // Test reading data when the file path is invalid.
        Assertions.assertThrows(IOException.class, () -> {
            storage.readData(INVALID_PATH);
        });
    }

    @Test
    public void testSaveIOException() {
        // Test reading data when the file path is invalid.
        Assertions.assertThrows(IOException.class, () -> {
            storage.saveData(data, INVALID_PATH);
        });
    }

    @Test
    public void testTempFile() {
        // Save the data in the storage.
        try {
            storage.saveData(data, USERDATA_PATH);
        } catch (IOException exception) {
            Assertions.fail("Exception thrown while saving the data: " + exception.getMessage());
        }
        // Check if the temporary file has been deleted.
        Path path = Path.of(TEMP_PATH);
        Assertions.assertFalse(Files.exists(path));
    }
}
