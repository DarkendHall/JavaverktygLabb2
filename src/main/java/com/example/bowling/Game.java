package com.example.bowling;

public class Game {

    private int frameScore = 0;

    private int rolls = 0;

    private int score = 0;

    public int score() {
        return score;
    }

    public void roll(int pins) {
        if (rolls == 2) {
            if (frameScore == 10) {
                rolls = 0;
                score += pins;
                frameScore = 0;
            }
        }
        frameScore += pins;
        score += pins;
        rolls++;
    }
}
