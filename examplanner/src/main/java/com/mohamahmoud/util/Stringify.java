package com.mohamahmoud.util;

import com.mohamahmoud.data.SemesterData;
import com.mohamahmoud.model.Entry;
import com.mohamahmoud.model.Semester;

public class Stringify {
    private static final String LINEBREAK = System.lineSeparator();
    private static final String SEPARATOR = " ";

    /**
     * Formats the {@link SemesterData} into readable and structured text.
     * 
     * @param semesterData The {@link SemesterData} to be formatted
     * @return The formatted {@link SemesterData}
     */
    public static String format(SemesterData semesterData) {
        // Initializing the StringBuilder.
        StringBuilder builder = new StringBuilder();
        // Showing the current semester.
        builder.append("Current Semester: " + LINEBREAK);
        builder.append(semesterData.currentSemester().toString() + LINEBREAK);
        // Showing the semesters.
        builder.append("Semesters: " + LINEBREAK);
        for (Semester semester : semesterData.semesters()) {
            builder.append(semester.toString() + LINEBREAK);
        }
        // Return the formatted String.
        return builder.toString().trim();
    }

    /**
     * Formats the {@link Semester} into readable and structured text.
     * 
     * @param semester The {@link Semester} to be formatted
     * @return The formatted {@link Semester}
     */
    public static String format(Semester semester) {
        // Initializing the StringBuilder.
        StringBuilder builder = new StringBuilder();
        // Showing the name of the semester.
        builder.append(SEPARATOR + "Name: " + LINEBREAK);
        builder.append(SEPARATOR + SEPARATOR + semester.getName() + LINEBREAK);
        // Showing the entries.
        builder.append(SEPARATOR + "Entries: " + LINEBREAK);
        for (Entry entry : semester.getEntries()) {
            builder.append(SEPARATOR + SEPARATOR + entry.toString() + LINEBREAK);
        }
        // Return the formatted String.
        return builder.toString();
    }

    /**
     * Formats the {@link Entry} into readable and structured text.
     * 
     * @param semester The {@link Entry} to be formatted
     * @return The formatted {@link Entry}
     */
    public static String format(Entry entry) {
        // Initializing the StringBuilder.
        StringBuilder builder = new StringBuilder();
        // Add the date.
        builder.append(entry.date().toString() + ", ");
        // Add the name.
        builder.append(entry.name() + ", ");
        // Add the ects points.
        builder.append(entry.ects() + ", ");
        // Add the state.
        builder.append(entry.state().toString() + ", ");
        // Add the grade.
        builder.append(entry.grade() + ",");
        // Add the score.
        builder.append(entry.score().toString());
        // Return the formatted String.
        return builder.toString();
    }
}
