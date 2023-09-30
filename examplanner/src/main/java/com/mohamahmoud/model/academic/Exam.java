package com.mohamahmoud.model.academic;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mohamahmoud.model.grading.Grade;
import com.mohamahmoud.model.grading.Score;
import com.mohamahmoud.model.grading.State;
import com.mohamahmoud.util.Stringify;

/**
 * This class represents an {@link Exam} that can be part of a {@link Semester}.
 * 
 * @author Mohammad Mahmoud
 * @version 1.4
 */
public record Exam(LocalDate date, String name, int ects, State state, Grade grade, Score score) {
    @Override
    public boolean equals(Object obj) {
        // Check if the two objects are from the same class.
        if (obj == null || (this.getClass() != obj.getClass()))
            return false;

        // Check equality.
        Exam other = (Exam) obj;
        return (date.equals(other.date()) &&
                name.equals(other.name()) &&
                ects == other.ects() &&
                state == other.state() &&
                grade.equals(other.grade()) &&
                score.equals(other.score()));
    }
}
