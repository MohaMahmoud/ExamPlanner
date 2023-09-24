package com.mohamahmoud.model;

public record Score(float achievedPoints, float totalPoints) {
    
    @Override
    public String toString() {
        return achievedPoints + "/" + totalPoints;
    }
}
