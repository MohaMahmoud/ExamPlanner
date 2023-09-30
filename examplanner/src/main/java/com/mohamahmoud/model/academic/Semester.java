package com.mohamahmoud.model.academic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mohamahmoud.util.Stringify;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class represents a {@link Semester} in the Exam Planner.
 * 
 * @author Mohammad Mahmoud
 * @version 1.2
 */
public class Semester {
    private final String name;
    private List<Exam> exams;

    /**
     * Constructs a new {@link Semester} with the specified name.
     * 
     * @param name The specified name
     */
    @JsonCreator
    public Semester(@JsonProperty("name") String name) {
        this.name = name;
        this.exams = new ArrayList<>();
    }

    /**
     * Gets the name of the {@link Semester}.
     * 
     * @return The name of the {@link Semester}
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the entries of the {@link Semester}.
     * 
     * @return The entries of the {@link Semester}
     */
    public List<Exam> getExams() {
        return Collections.unmodifiableList(exams);
    }

    /**
     * Sets the entries of the {@link Semester} to the specified entries.
     * 
     * @param entries The specified entries
     */
    public void setExams(List<Exam> entries) {
        this.exams = entries;
    }

    /**
     * Adds an {@link Exam} to the List of entries.
     * 
     * @param entry The {@link Exam} to be added.
     */
    public void addEntry(Exam entry) {
        exams.add(entry);
        Collections.sort(exams, Comparator.comparing(Exam::date));
    }

    /**
     * Removes an {@link Exam} from the List of entries.
     * 
     * @param entry The {@link Exam} to be removed.
     */
    public void removeEntry(Exam entry) {
        exams.remove(entry);
    }

    @Override
    public boolean equals(Object obj) {
        // Check if the two objects are from the same class.
        if (obj == null || (this.getClass() != obj.getClass()))
            return false;

        // Check equality.
        Semester other = (Semester) obj;
        return exams.equals(other.getExams()) && name.equals(other.getName());
    }

    @Override
    public String toString() {
        return Stringify.format(this);
    }
}
