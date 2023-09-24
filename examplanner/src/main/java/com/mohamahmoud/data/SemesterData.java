package com.mohamahmoud.data;

import java.util.Collections;
import java.util.List;

import com.mohamahmoud.model.Semester;

/**
 * This record represents the nested data that is displayed in the table view.
 * 
 * @author Mohammad Mahmoud
 * @version 1.0
 */
public record SemesterData(List<Semester> semesters, Semester currentSemester) {

    @Override
    public List<Semester> semesters() {
        return Collections.unmodifiableList(semesters);
    }
}
