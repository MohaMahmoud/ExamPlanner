package com.mohamahmoud.data;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is responsible for saving and reading data of the user.
 * 
 * @author Mohammad Mahmoud
 * @version 1.0
 */
public class DataStorage {

    /**
     * Saves the data to the JSON File.
     * 
     * @param data The data to be saved
     * @throws IOException If an error occurs while saving the data
     */
    public void saveData(SemesterData data, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(getJSONFile(path), data);
    }

    /**
     * Reads the data from the JSON File.
     * 
     * @throws IOException If an error occurs while reading the data
     */
    public SemesterData readData(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(getJSONFile(path), SemesterData.class);
    }

    /**
     * Retrieves the JSON File and returns a temporary copy of it.
     * 
     * @return The JSON File
     * @throws IOException If the file was not found
     */
    private File getJSONFile(String path) throws IOException {
        // Retrieve input stream for the json file.
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        if (inputStream == null) throw new IOException("Could not find File: " + path);
        // Create a temporary file that is deleted on exit.
        File temp = File.createTempFile("temp", ".json");
        temp.deleteOnExit();
        // Copy the content from the input stream to the temporary file.
        try {
            Files.copy(inputStream, temp.toPath());
        } finally {
            // Ensure input stream is properly closed.
            inputStream.close();
        }
        // Return the temporary file.
        return temp;
    }
}
