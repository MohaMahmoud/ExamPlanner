package com.mohamahmoud.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import com.mohamahmoud.model.Semester;

/**
 * This class tests the {@link SemesterData} class.
 * 
 * @author Mohammad Mahmoud
 * @version 1.0
 */
public class SemesterDataTest {
    private List<Semester> semesters;
    private Semester currentSemester;

    @BeforeEach
    public void setup() {
        // Initiate semesters.
        Semester semester1 = new Semester("Wintersemester 2022/23");
        Semester semester2 = new Semester("Sommersemester 2023");
        Semester semester3 = new Semester("Wintersemester 2023/24");
        Semester semester4 = new Semester("Sommersemester 2024");
        // Add semesters to the list and select current semester.
        semesters = List.of(semester1, semester2, semester3, semester4);
        currentSemester = semester1;
    }

    @Test
    public void testGetters() {
        // Initialize new SemesterData Object.
        SemesterData data = new SemesterData(semesters, currentSemester);
        // Test semesters() and currentSemester().
        List<Semester> retrievedSemesters = data.semesters();
        Semester retrievedCurrentSemester = data.currentSemester();
        // Compare the values.
        Assertions.assertEquals(semesters, retrievedSemesters);
        Assertions.assertEquals(currentSemester, retrievedCurrentSemester);
    }
}
