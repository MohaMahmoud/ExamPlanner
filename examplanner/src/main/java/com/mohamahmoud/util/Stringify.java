package com.mohamahmoud.util;

import com.mohamahmoud.data.Data;
import com.mohamahmoud.model.academic.Entry;
import com.mohamahmoud.model.academic.Semester;

public final class Stringify {
    public static final String BR = System.lineSeparator();

    /**
     * Formats the {@link Data} into readable and structured text.
     * 
     * @param semesterData The {@link Data} to be formatted
     * @return The formatted {@link Data}
     */
    public static String format(Data data) {
        // Initialize the StringBuilder.
        StringBuilder builder = new StringBuilder();
        // Show the current semester.
        builder.append("Current Semester:" + BR);
        builder.append(data.getCurrentSemester().getName() + BR + BR);
        // Show the semesters.
        builder.append("Semesters:" + BR);
        for (Semester semester : data.getSemesters()) {
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

        StringBuilder builder = new StringBuilder();
        String format = "Date: %s, Name: %s, ECTS: %d, Result: %s";
        builder.append(String.format(
                format,
                entry.getDate(),
                entry.getName(),
                entry.getEcts(),
                entry.getResult()));
        return builder.toString();
    }
}
