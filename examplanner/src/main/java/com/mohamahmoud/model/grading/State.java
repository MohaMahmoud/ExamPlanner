package com.mohamahmoud.model.grading;

/**
 * This enum represents the different states an {@link Entry} can be in.
 * 
 * @author Mohammad Mahmoud
 * @version 1.0
 */
public enum State {
    /**
     * The {@link Entry} is passed.
     */
    PASSED,

    /**
     * The {@link Entry} is failed.
     */
    FAILED,

    /**
     * The {@link State} of the {@link Entry} is unknown.
     */
    UNKNOWN
}
