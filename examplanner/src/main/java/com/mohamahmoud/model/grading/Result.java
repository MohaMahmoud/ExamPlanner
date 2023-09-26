package com.mohamahmoud.model.grading;

/**
 * This record represents the {@link Result} of an {@link Entry}.
 * 
 * @author Mohammad Mahmoud
 * @version 1.0
 */
public record Result(State state, Grade grade, Score score) { 
    @Override
    public String toString() {
        return "Result: " + state.toString() + ", " + grade.toString() + ", " + score.toString();
    }
}
