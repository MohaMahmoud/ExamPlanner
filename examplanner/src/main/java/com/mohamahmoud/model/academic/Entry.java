package com.mohamahmoud.model.academic;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mohamahmoud.model.grading.Result;
import com.mohamahmoud.util.Stringify;

/**
 * This class represents an {@link Entry} that can be part of a {@link Semester}.
 * 
 * @author Mohammad Mahmoud
 * @version 1.4
 */
public class Entry {
    private LocalDate date;
    private String name;
    private int ects;
    private Result result;

    /**
     * Constructs a new {@link Entry} with the given attributes.
     * 
     * @param date The date of the {@link Entry}
     * @param name The name of the {@link Entry}
     * @param ects The ects points of the {@link Entry}
     * @param result The result of the {@link Entry}
     */
    @JsonCreator
    public Entry(@JsonProperty("date") LocalDate date, 
                 @JsonProperty("name") String name, 
                 @JsonProperty("ects") int ects, 
                 @JsonProperty("result") Result result) {
        this.date = date;
        this.name = name;
        this.ects = ects;
        this.result = result;
    }

    /**
     * Gets the date of the {@link Entry}.
     * 
     * @return The date of the {@link Entry}
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date to the new date.
     * 
     * @param date The new date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the name of the {@link Entry}.
     * 
     * @return The name of the {@link Entry}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name to the new name.
     * 
     * @param name The new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the ects points of the {@link Entry}.
     * 
     * @return The ects points of the {@link Entry}
     */
    public int getEcts() {
        return ects;
    }

    /**
     * Sets the ects points to the new ects points.
     * 
     * @param ects The new ects points
     */
    public void setEcts(int ects) {
        this.ects = ects;
    }

    /**
     * Gets the result of the {@link Entry}.
     * 
     * @return The result of the {@link Entry}
     */
    public Result getResult() {
        return result;
    }

    /**
     * Sets the result to the new result.
     * 
     * @param result The new result
     */
    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return Stringify.format(this);
    }
}
