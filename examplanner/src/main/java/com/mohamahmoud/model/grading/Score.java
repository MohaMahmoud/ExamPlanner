package com.mohamahmoud.model.grading;

import com.mohamahmoud.model.academic.Exam;

/**
 * This record represents the {@link Score} of an {@link Exam}.
 * 
 * @author Mohammad Mahmoud
 * @version 1.1
 */
public record Score(float achievedPoints, float totalPoints) {
    @Override
    public boolean equals(Object obj) {
        // Check if the two objects are from the same class.
        if (obj == null || (this.getClass() != obj.getClass())) return false;

        // Check equality.
        Score other = (Score) obj;
        return (achievedPoints == other.achievedPoints()) && (totalPoints == other.totalPoints());
    }

    @Override
    public String toString() {
        return (achievedPoints + "/" + totalPoints);
    }
}
