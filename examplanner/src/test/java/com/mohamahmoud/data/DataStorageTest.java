package com.mohamahmoud.data;

import org.junit.jupiter.api.Test;

import com.mohamahmoud.model.academic.Semester;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * This class tests the {@link DataStorage} class.
 * 
 * @author Mohammad Mahmoud
 * @version 1.0
 */
public class DataStorageTest {

    private DataStorage storage;
    private Data data;

    @BeforeEach
    public void setup() {
        // Initiate data storage.
        storage = new DataStorage();
        // Initiate semester data.
        Semester semester1 = new Semester("Wintersemester 2022/23");
        Semester semester2 = new Semester("Sommersemester 2023");
        data = new Data(List.of(semester1, semester2), semester1);
    }

    @Test
    public void testSaveAndReadData() {
        // Test the saving of the data.
        try {
            storage.saveData(data);
        } catch (IOException exception) {
            Assertions.fail("Exception thrown while saving the data: " + exception.getMessage());
        }
        // Test the reading of the data.
        try {
            Data retrievedData = storage.readData();

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
            storage.readData();
        });
    }

    @Test
    public void testSaveIOException() {
        // Test reading data when the file path is invalid.
        Assertions.assertThrows(IOException.class, () -> {
            storage.saveData(data);
        });
    }

    @Test
    public void testTempFile() {
        // Save the data in the storage.
        try {
            storage.saveData(data);
        } catch (IOException exception) {
            Assertions.fail("Exception thrown while saving the data: " + exception.getMessage());
        }
        // Check if the temporary file has been deleted.

        // TODO
    }
}
