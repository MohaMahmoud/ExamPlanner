package com.mohamahmoud.model;

public record Score(float achievedPoints, float totalPoints) {

    @Override
    public boolean equals(Object obj) {
        // Default return values if it is the same object.
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        // Cast the object because we know it's the same type.
        Score other = (Score) obj;
        return (Float.compare(achievedPoints, other.achievedPoints) == 0) && (Float.compare(totalPoints, other.totalPoints) == 0);
    }

    @Override
    public String toString() {
        return achievedPoints + "/" + totalPoints;
    }
}
