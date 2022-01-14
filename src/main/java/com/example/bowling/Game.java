package com.example.bowling;

public class Game {

    private boolean lastFrameWasStrike = false;

    private int strikeBonus = 0;

    private int frameScore = 0;

    private int rolls = 0;

    private int score = 0;

    public int score() {
        return score;
    }

    public void roll(int pins) {
        if (lastFrameWasStrike) {
            strikeBonus += pins;
            lastFrameWasStrike = false;
            score += strikeBonus;
        }

        if (rolls == 2) {
            if (frameScore == 10) {
                rolls = 0;
                score += pins;
            }
            frameScore = 0;
        }

        if (rolls == 1 && frameScore == 10) {
            rolls = 0;
            strikeBonus += pins;
            lastFrameWasStrike = true;
        }

        frameScore += pins;
        score += pins;
        rolls++;
    }
}
