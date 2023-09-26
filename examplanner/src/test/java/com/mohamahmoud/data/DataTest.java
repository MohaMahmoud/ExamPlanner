package com.mohamahmoud.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.mohamahmoud.model.academic.Entry;
import com.mohamahmoud.model.academic.Semester;
import com.mohamahmoud.model.grading.Score;
import com.mohamahmoud.model.grading.State;
import com.mohamahmoud.util.Stringify;

/**
 * This class tests the {@link Data} class.
 * 
 * @author Mohammad Mahmoud
 * @version 1.0
 */
public class DataTest {
    private List<Semester> semesters;
    private Semester currentSemester;

    @BeforeEach
    public void setup() {
        // Initiate semesters.
        Semester semester1 = new Semester("Wintersemester 2022/23");
        Semester semester2 = new Semester("Sommersemester 2023");
        Semester semester3 = new Semester("Wintersemester 2023/24");
        Semester semester4 = new Semester("Sommersemester 2024");
        // Add an entry to the current semester.
        Entry entry1 = new Entry(LocalDate.MIN, "Beginning", 0, State.PASSED, 1.0f, new Score(100f, 100f));
        Entry entry2 = new Entry(LocalDate.MAX, "Ending", 10, State.FAILED, 5.0f, new Score(0f,100f));
        semester1.addEntry(entry1);
        semester2.addEntry(entry2);
        // Add semesters to the list and select current semester.
        semesters = List.of(semester1, semester2, semester3, semester4);
        currentSemester = semester1;
    }

    @Test
    public void testGetters() {
        // Initialize new SemesterData Object.
        Data data = new Data(semesters, currentSemester);
        // Test semesters() and currentSemester().
        List<Semester> retrievedSemesters = data.semesters();
        Semester retrievedCurrentSemester = data.currentSemester();
        // Compare the values.
        Assertions.assertEquals(semesters, retrievedSemesters);
        Assertions.assertEquals(currentSemester, retrievedCurrentSemester);
    }

    @Test
    public void testEqualsAndHashCode() {
        // Create a copy of the semester data.
        Data data = new Data(semesters, currentSemester);
        Data copy = new Data(semesters, currentSemester);
        // Test equality.
        Assertions.assertTrue(data.equals(copy));
        Assertions.assertTrue(copy.equals(data));
        // Test hashcode.
        Assertions.assertEquals(data.hashCode(), copy.hashCode());
        // Modify one of the semesters in the copy.
        copy.semesters().get(0).addEntry(new Entry(LocalDate.now(), "Modified", 0, State.UNKNOWN, 1.0f, new Score(100f, 100f)));
        // Test inequality after modifying the copy.
        Assertions.assertFalse(data.equals(copy));
        Assertions.assertFalse(copy.equals(data));
    }

    @Test
    public void testFormatting() {
        // Initialize new SemesterData Object.
        Data data = new Data(semesters, currentSemester);
        // Expected Formatting.
        StringBuilder builder = new StringBuilder();
        // Showing the current semester.
        builder.append("Current Semester:" + Stringify.BR);
        builder.append(data.currentSemester().getName() + Stringify.BR + Stringify.BR);
        // Showing the semesters.
        builder.append("Semesters:" + Stringify.BR);
        for (Semester semester : data.semesters()) {
            builder.append(semester.getName() + Stringify.BR);
        }
        // Saving the final Format
        String format = builder.toString().trim();
        // Test the formatting.
        String retrievedFormat = data.toString();
        // Compare the values.
        Assertions.assertEquals(format, retrievedFormat);
    }
}
