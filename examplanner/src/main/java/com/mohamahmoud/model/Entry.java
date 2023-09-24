package com.mohamahmoud.model;

import java.util.Date;

import com.mohamahmoud.util.Stringify;

public record Entry(Date date, String name, int ects, State state, float grade, Score score) {
    
    @Override
    public String toString() {
        return Stringify.format(this);
    }
}
