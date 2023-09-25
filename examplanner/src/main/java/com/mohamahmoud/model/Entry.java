package com.mohamahmoud.model;

import java.time.LocalDate;

import com.mohamahmoud.util.Stringify;

public record Entry(LocalDate date, String name, int ects, State state, float grade, Score score) {

    @Override
    public boolean equals(Object obj) {
        // Default return values if it is the same object.
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        // Cast the object because we know it's the same type.
        Entry other = (Entry) obj;
        return date.equals(other.date) &&
                name.equals(other.name) &&
                ects == other.ects &&
                state == other.state &&
                Float.compare(grade, other.grade) == 0 &&
                score.equals(other.score);
    }

    @Override
    public String toString() {
        return Stringify.format(this);
    }
}
