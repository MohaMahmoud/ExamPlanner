package com.mohamahmoud.data;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mohamahmoud.model.academic.Semester;
import com.mohamahmoud.util.Stringify;

/**
 * This record represents the nested data that is displayed in the table view.
 * 
 * @author Mohammad Mahmoud
 * @version 1.0
 */
public class Data {
    private final List<Semester> semesters;
    private final Semester currentSemester;

    @JsonCreator
    public Data(@JsonProperty("semesters") List<Semester> semesters, 
                @JsonProperty("currentSemester") Semester currentSemester) {
        this.semesters = semesters;
        this.currentSemester = currentSemester;
    }

    public List<Semester> getSemesters() {
        return Collections.unmodifiableList(semesters);
    }

    public Semester getCurrentSemester() {
        return currentSemester;
    }

    @Override
    public boolean equals(Object obj) {
        // Check if the two objects are from the same class.
        if (obj == null || (this.getClass() != obj.getClass()))
            return false;

        // Check equality.
        Data other = (Data) obj;
        return currentSemester.equals(other.getCurrentSemester()) && semesters.equals(other.getSemesters());
    }

    @Override
    public String toString() {
        return Stringify.format(this);
    }
}
