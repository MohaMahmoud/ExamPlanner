package com.mohamahmoud.model.grading;

/**
 * This record represents the {@link Score} of an {@link Entry}.
 * 
 * @author Mohammad Mahmoud
 * @version 1.1
 */
public record Score(float achievedPoints, float totalPoints) {
    @Override
    public String toString() {
        return (achievedPoints + "/" + totalPoints);
    }
}
