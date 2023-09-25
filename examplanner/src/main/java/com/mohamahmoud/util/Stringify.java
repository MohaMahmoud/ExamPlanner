package com.mohamahmoud.util;

import com.mohamahmoud.data.Data;
import com.mohamahmoud.model.Entry;
import com.mohamahmoud.model.Semester;

public class Stringify {
    public static final String BR = System.lineSeparator();
    private static final String SEPARATOR = " ";

    /**
     * Formats the {@link Data} into readable and structured text.
     * 
     * @param semesterData The {@link Data} to be formatted
     * @return The formatted {@link Data}
     */
    public static String format(Data semesterData) {
        // Initialize the StringBuilder.
        StringBuilder builder = new StringBuilder();
        // Show the current semester.
        builder.append("Current Semester:" + BR);
        builder.append(semesterData.currentSemester().getName() + BR + BR);
        // Show the semesters.
        builder.append("Semesters:" + BR);
        for (Semester semester : semesterData.semesters()) {
            builder.append(semester.getName() + BR);
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
        // Initialize the StringBuilder.
        StringBuilder builder = new StringBuilder();
        // Show the name of the semester.
        builder.append("Name: " + BR);
        builder.append(semester.getName() + BR + BR);
        // Show the entries.
        builder.append("Entries: " + BR);
        for (Entry entry : semester.getEntries()) {
            builder.append(entry.toString() + BR);
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
        // Initialize the StringBuilder.
        StringBuilder builder = new StringBuilder();
        String format = "Date: %s, Name: %s, ECTS: %d, State: %s, Grade: %s, Score: %s"; // TODO Test that formatting.
        builder.append(String.format(format, entry.date(), entry.name(), entry.ects(), entry.state(), entry.grade(), entry.score()));
        return builder.toString();
    }
}
