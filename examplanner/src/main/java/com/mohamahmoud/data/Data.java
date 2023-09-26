package com.mohamahmoud.data;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public Data(List<Semester> semesters, Semester currentSemester) {
        this.semesters = semesters;
        this.currentSemester = currentSemester;
    }

    public List<Semester> getSemesters() {
        return Collections.unmodifiableList(semesters);
    }

    public Semester getCurrentSemester() {
        return currentSemester;
    }

    // TODO
    @Override
    public boolean equals(Object obj) {
        // Default return values if it is the same object.
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        // Cast the object because we know it's the same type.
        Data other = (Data) obj;
        // Comparing the List of semesters and the current semester.
        return semesters.equals(other.semesters) && currentSemester.equals(other.currentSemester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semesters, currentSemester);
    }

    @Override
    public String toString() {
        return Stringify.format(this);
    }
}
