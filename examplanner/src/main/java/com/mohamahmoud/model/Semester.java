package com.mohamahmoud.model;

import java.util.Collections;
import java.util.List;

import com.mohamahmoud.util.Stringify;

import java.util.ArrayList;

public class Semester {
    private String name;
    private final List<Entry> entries;

    // Default (no-argument) constructor
    public Semester() {
        this.entries = new ArrayList<>();
    }

    public Semester(String name) {
        this.name = name;
        this.entries = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Entry> getEntries() {
        return Collections.unmodifiableList(entries);
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public void removeEntry(Entry entry) {
        entries.remove(entry);
    }

    @Override
    public boolean equals(Object obj) {
        // Default return values if it is the same object.
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        // Cast the object because we know it's the same type.
        Semester other = (Semester) obj;
        // Comparing the List of semesters and the current semester.
        return entries.equals(other.entries) && name.equals(other.name);
    }

    @Override
    public String toString() {
        return Stringify.format(this);
    }
}
