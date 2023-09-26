package com.mohamahmoud.model.grading;

/**
 * This record represents the {@link Grade} of an {@link Entry}.
 * 
 * @author Mohammad Mahmoud
 * @version 1.2
 */
public record Grade(Float value, boolean isBonus) {
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
