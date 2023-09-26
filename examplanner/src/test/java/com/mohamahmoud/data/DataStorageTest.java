package com.mohamahmoud.data;

import org.junit.jupiter.api.Test;

import com.mohamahmoud.model.academic.Semester;
import com.mohamahmoud.util.DataComparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
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
            Assertions.assertTrue(DataComparator.compareData(data, retrievedData));
        } catch (IOException exception) {
            Assertions.fail("Exception thrown while reading the data: " + exception.getMessage());
        }
    }
}
