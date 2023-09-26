package com.mohamahmoud.model;

import org.junit.jupiter.api.Test;

import com.mohamahmoud.model.grading.Score;

import org.junit.jupiter.api.Assertions;

/**
 * This class tests the {@link Score} class.
 * 
 * @author Mohammad Mahmoud,
 * @version 1.0
 */
public class ScoreTest {
    
    @Test
    public void testFormatting() {
        Assertions.assertEquals("75.0/100.0", new Score(75.0f, 100.0f).toString());
    }
}
