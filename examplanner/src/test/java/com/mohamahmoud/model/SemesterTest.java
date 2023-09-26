package com.mohamahmoud.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mohamahmoud.model.academic.Entry;
import com.mohamahmoud.model.academic.Semester;
import com.mohamahmoud.model.grading.Score;
import com.mohamahmoud.model.grading.State;

public class SemesterTest {
    
    private Semester semester1;
    private Semester semester2;

    @BeforeEach
    public void setup() {
        // Create two semesters with the same name
        semester1 = new Semester("Wintersemester 2022/23");
        semester2 = new Semester("Wintersemester 2022/23");
    }
    
    @Test
    public void testAddEntry() {
        // Initially, both semesters have empty lists of entries
        assertTrue(semester1.getEntries().isEmpty());
        assertTrue(semester2.getEntries().isEmpty());

        // Add an entry to semester1
        Entry entry = new Entry(null, "Sample Entry", 0, State.UNKNOWN, 0.0f, new Score(0.0f, 0.0f));
        semester1.addEntry(entry);

        // Now, semester1 should have one entry, while semester2 remains empty
        assertEquals(1, semester1.getEntries().size());
        assertTrue(semester2.getEntries().isEmpty());
    }

    @Test
    public void testRemoveEntry() {
        // Initially, both semesters have empty lists of entries
        assertTrue(semester1.getEntries().isEmpty());
        assertTrue(semester2.getEntries().isEmpty());

        // Add an entry to semester1
        Entry entry = new Entry(null, "Sample Entry", 0, State.UNKNOWN, 0.0f, new Score(0.0f, 0.0f));
        semester1.addEntry(entry);

        // Now, semester1 should have one entry, while semester2 remains empty
        assertEquals(1, semester1.getEntries().size());
        assertTrue(semester2.getEntries().isEmpty());

        // Remove the entry from semester1
        semester1.removeEntry(entry);

        // Now, both semesters should have empty lists of entries
        assertTrue(semester1.getEntries().isEmpty());
        assertTrue(semester2.getEntries().isEmpty());
    }
}
