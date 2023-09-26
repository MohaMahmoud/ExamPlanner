package com.mohamahmoud.util;

import java.util.List;
import java.util.Objects;

import com.mohamahmoud.data.Data;
import com.mohamahmoud.model.academic.Semester;
import com.mohamahmoud.model.academic.Entry;
import com.mohamahmoud.model.grading.Result;
import com.mohamahmoud.model.grading.Grade;
import com.mohamahmoud.model.grading.Score;

/**
 * This utility class is used to compare the different building blocks
 * of the Exam Planner.
 * 
 * @author Mohammad Mahmoud
 * @version 1.1
 */
public final class DataComparator {

    private DataComparator() {
        // Utility class cannot be instantiated.
    }

    /**
     * Compares two building blocks of the type {@link Data}.
     * 
     * @param data1 The first object to be compared
     * @param data2 The second object to be compared
     * @return {@code True} if the objects are equal, {@code False} otherwise
     */
    public static boolean compareData(Data data1, Data data2) {
        // Check for null references.
        if (data1 == null) {
            return (data2 == null);
        }

        // Compare the List of semesters.
        List<Semester> semesters1 = data1.getSemesters();
        List<Semester> semesters2 = data2.getSemesters();

        // Check for null references
        if (semesters1 == null) {
            return (semesters2 == null);
        }

        // Compare the List length.
        if (semesters1.size() != semesters2.size()) {
            return false;
        }

        // Compare the individual semesters.
        for (int i = 0; i < semesters1.size(); i++) {
            if (!compareSemester(semesters1.get(i), semesters2.get(i))) {
                return false;
            }
        }

        // Compare the current semester.
        return compareSemester(data1.getCurrentSemester(), data2.getCurrentSemester());
    }

    /**
     * Compares two building blocks of the type {@link Semester}.
     * 
     * @param data1 The first object to be compared
     * @param data2 The second object to be compared
     * @return {@code True} if the objects are equal, {@code False} otherwise
     */
    public static boolean compareSemester(Semester semester1, Semester semester2) {
        // Check for null references.
        if (semester1 == null) {
            return (semester2 == null);
        }

        // Compare the List of entries.
        List<Entry> entries1 = semester1.getEntries();
        List<Entry> entries2 = semester2.getEntries();

        // Check for null references.
        if (entries1 == null) {
            return (entries2 == null);
        }

        // Compare the List length.
        if (entries1.size() != entries2.size()) {
            return false;
        }

        // Compare the individual entries.
        for (int i = 0; i < entries1.size(); i++) {
            if (!compareEntry(entries1.get(i), entries2.get(i))) {
                return false;
            }
        }

        // Compare the name.
        return Objects.equals(semester1.getName(), semester2.getName());
    }

    /**
     * Compares two building blocks of the type {@link Entry}.
     * 
     * @param data1 The first object to be compared
     * @param data2 The second object to be compared
     * @return {@code True} if the objects are equal, {@code False} otherwise
     */
    public static boolean compareEntry(Entry entry1, Entry entry2) {
        // Check for null references.
        if (entry1 == null) {
            return (entry2 == null);
        }

        // Compare the date.
        if (!Objects.equals(entry1.getDate(), entry2.getDate())) {
            return false;
        }

        // Compare the name.
        if (!Objects.equals(entry1.getName(), entry2.getName())) {
            return false;
        }

        // Compare the ects points.
        if (entry1.getEcts() != entry2.getEcts()) {
            return false;
        }

        // Compare the result.
        return (compareResult(entry1.getResult(), entry2.getResult()));
    }

    /**
     * Compares two building blocks of the type {@link Result}.
     * 
     * @param data1 The first object to be compared
     * @param data2 The second object to be compared
     * @return {@code True} if the objects are equal, {@code False} otherwise
     */
    public static boolean compareResult(Result result1, Result result2) {
        // Compare the state.
        if (result1.state() != result2.state()) {
            return false;
        }

        // Compare the grade and the score.
        return compareGrade(result1.grade(), result2.grade()) && compareScore(result1.score(), result2.score());
    }

    /**
     * Compares two building blocks of the type {@link Grade}.
     * 
     * @param data1 The first object to be compared
     * @param data2 The second object to be compared
     * @return {@code True} if the objects are equal, {@code False} otherwise
     */
    public static boolean compareGrade(Grade grade1, Grade grade2) {
        // Check for null references.
        if (grade1 == null) {
            return (grade2 == null);
        }

        // Compare the grade.
        return grade1.value() == grade2.value() && grade1.isBonus() == grade2.isBonus();
    }

    /**
     * Compares two building blocks of the type {@link Score}.
     * 
     * @param data1 The first object to be compared
     * @param data2 The second object to be compared
     * @return {@code True} if the objects are equal, {@code False} otherwise
     */
    public static boolean compareScore(Score score1, Score score2) {
        // Check for null references.
        if (score1 == null) {
            return (score2 == null);
        }

        // Compare the score.
        return score1.achievedPoints() == score2.achievedPoints() && score1.totalPoints() == score2.totalPoints();
    }

}
