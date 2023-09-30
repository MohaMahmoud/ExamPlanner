package com.mohamahmoud.model.grading;

import com.mohamahmoud.model.academic.Exam;

/**
 * This record represents the {@link Grade} of an {@link Exam}.
 * 
 * @author Mohammad Mahmoud
 * @version 1.2
 */
public record Grade(float value) {
    @Override
    public boolean equals(Object obj) {
        // Check if the two objects are from the same class.
        if (obj == null || (this.getClass() != obj.getClass())) return false;

        // Check equality.
        Grade other = (Grade) obj;
        return (value == other.value());
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
