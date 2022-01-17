package com.example.bowling;

public class Game {

    private boolean lastFrameWasStrike = false;

    private int frameCount = 0;

    private int strikeBonus = 0;

    private int frameScore = 0;

    private int rolls = 0;

    private int score = 0;

    public int score() {
        return score;
    }

    public void roll(int pins) {

        if (rolls == 3)
            return;

        if (frameCount == 9){
            frameScore += pins;
            score += pins;
            rolls++;
            return;
        }

        if (lastFrameWasStrike) {
            strikeBonus += pins;
            lastFrameWasStrike = false;
            score += strikeBonus;
            strikeBonus = 0;
        }

        if (rolls == 2 && frameScore == 10) {
            rolls = 0;
            score += pins;
            frameScore = 0;
            frameCount++;
        }

        if (rolls == 1 && frameScore == 10) {
            rolls = 0;
            strikeBonus += pins;
            lastFrameWasStrike = true;
            frameScore = 0;
            frameCount++;
        }

        if (rolls == 2) {
            rolls = 0;
            frameScore = 0;
            frameCount++;
        }

        frameScore += pins;
        score += pins;
        rolls++;
    }
}