package com.mohamahmoud.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.List;

import com.mohamahmoud.model.academic.Entry;
import com.mohamahmoud.model.academic.Semester;
import com.mohamahmoud.model.grading.Grade;
import com.mohamahmoud.model.grading.Result;
import com.mohamahmoud.model.grading.Score;
import com.mohamahmoud.model.grading.State;
import com.mohamahmoud.util.DataComparator;
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
        Score score1 = new Score(100.0f, 100.0f);
        Grade grade1 = new Grade(1.0f, false);
        Result result1 = new Result(State.PASSED, grade1, score1);
        Entry entry1 = new Entry(LocalDate.MIN, "Beginning", 0, result1);
        semester1.addEntry(entry1);
        // Add another entry to a different semester
        Score score2 = new Score(0.0f, 100.0f);
        Grade grade2 = new Grade(null, true);
        Result result2 = new Result(State.FAILED, grade2, score2);
        Entry entry2 = new Entry(LocalDate.MAX, "Ending", 10, result2);
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
        List<Semester> retrievedSemesters = data.getSemesters();
        Semester retrievedCurrentSemester = data.getCurrentSemester();

        // Check for null references
        if (retrievedSemesters == null) {
            Assertions.fail("Getter returned null but shouldn't.");
        }

        // Compare the List length.
        if (retrievedSemesters.size() != semesters.size()) {
            Assertions.fail("Getter returned List with different size.");
        }

        // Compare the individual semesters.
        for (int i = 0; i < semesters.size(); i++) {
            if (!DataComparator.compareSemester(retrievedSemesters.get(i), semesters.get(i))) {
                Assertions.fail("Getter returned List with different semesters.");
            }
        }

        // Compare the current semester.
        if (!DataComparator.compareSemester(retrievedCurrentSemester, currentSemester)) {
            Assertions.fail("Getter returned different current semester.");
        }
    }

    @Test
    public void testFormatting() {
        // Initialize new SemesterData Object.
        Data data = new Data(semesters, currentSemester);

        // Test the formatting.
        String format = Stringify.format(data);
        String retrievedFormat = data.toString();

        // Compare the values.
        Assertions.assertEquals(format, retrievedFormat);
    }
}
