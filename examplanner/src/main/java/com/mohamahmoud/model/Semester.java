package com.mohamahmoud.model;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Semester {
    private final String name;
    private final List<Entry> entries;

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
    public String toString() {
        return name;
    }
}
