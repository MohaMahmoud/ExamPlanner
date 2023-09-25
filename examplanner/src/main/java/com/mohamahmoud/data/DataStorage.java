package com.mohamahmoud.data;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is responsible for saving and reading data of the user.
 * 
 * @author Mohammad Mahmoud
 * @version 1.0
 */
public class DataStorage {
    private static final String PATH = "userdata.json";

    /**
     * Saves the data to the JSON File.
     * 
     * @param data The data to be saved
     * @throws IOException If an error occurs while saving the data
     */
    public void saveData(Data data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(PATH), data);
    }

    /**
     * Reads the data from the JSON File.
     * 
     * @throws IOException If an error occurs while reading the data
     */
    public Data readData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(PATH), Data.class);
    }
}
