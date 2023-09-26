package com.mohamahmoud.model.academic;

import com.mohamahmoud.util.Stringify;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class represents a {@link Semester} in the Exam Planner.
 * 
 * @author Mohammad Mahmoud
 * @version 1.1
 */
public class Semester {
    private final String name;
    private final List<Entry> entries;

    /**
     * Constructs a new {@link Semester} with the specified name.
     * 
     * @param name The specified name
     */
    public Semester(String name) {
        this.name = name;
        this.entries = new ArrayList<>();
    }

    /**
     * Gets the name of the {@link Semester}.
     * 
     * @return The name of the {@link Semester}
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the entries of the {@link Semester}.
     * 
     * @return The entries of the {@link Semester}
     */
    public List<Entry> getEntries() {
        return Collections.unmodifiableList(entries);
    }

    /**
     * Adds an {@link Entry} to the List of entries.
     * 
     * @param entry The {@link Entry} to be added.
     */
    public void addEntry(Entry entry) {
        entries.add(entry);
        Collections.sort(entries, Comparator.comparing(Entry::getDate));
    }

    /**
     * Removes an {@link Entry} from the List of entries.
     * 
     * @param entry The {@link Entry} to be removed.
     */
    public void removeEntry(Entry entry) {
        entries.remove(entry);
    }

    @Override
    public String toString() {
        return Stringify.format(this);
    }
}
