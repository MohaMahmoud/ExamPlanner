package com.mohamahmoud.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mohamahmoud.model.academic.Exam;
import com.mohamahmoud.model.academic.Semester;
import com.mohamahmoud.model.grading.Grade;

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
        assertTrue(semester1.getExams().isEmpty());
        assertTrue(semester2.getExams().isEmpty());

        // Add an entry to semester1
        semester1.addEntry(createExampleEntry());

        // Now, semester1 should have one entry, while semester2 remains empty
        assertEquals(1, semester1.getExams().size());
        assertTrue(semester2.getExams().isEmpty());
    }

    @Test
    public void testRemoveEntry() {
        // Initially, both semesters have empty lists of entries
        assertTrue(semester1.getExams().isEmpty());
        assertTrue(semester2.getExams().isEmpty());

        // Add an entry to semester1
        Exam entry = createExampleEntry();
        semester1.addEntry(entry);

        // Now, semester1 should have one entry, while semester2 remains empty
        assertEquals(1, semester1.getExams().size());
        assertTrue(semester2.getExams().isEmpty());

        // Remove the entry from semester1
        semester1.removeEntry(entry);

        // Now, both semesters should have empty lists of entries
        assertTrue(semester1.getExams().isEmpty());
        assertTrue(semester2.getExams().isEmpty());
    }

    private Exam createExampleEntry() {
        return new Exam(LocalDate.EPOCH, "Too Hard", 10, State.UNKNOWN, new Grade(2.0f), new Score(0.0f, 100.0f));
    }
}
