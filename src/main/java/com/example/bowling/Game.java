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
        if (gameEnded(pins))
            return;
        wasLastFrameStrike(pins);
        isSpare(pins);
        isStrike(pins);
        isEndOfFrame();

        frameScore += pins;
        score += pins;
        rolls++;
    }

    private void isEndOfFrame() {
        if (rolls == 2) {
            rolls = 0;
            frameScore = 0;
            frameCount++;
        }
    }

    private void isStrike(int pins) {
        if (rolls == 1 && frameScore == 10) {
            rolls = 0;
            strikeBonus += pins;
            lastFrameWasStrike = true;
            frameScore = 0;
            frameCount++;
        }
    }

    private void isSpare(int pins) {
        if (rolls == 2 && frameScore == 10) {
            rolls = 0;
            score += pins;
            frameScore = 0;
            frameCount++;
        }
    }

    private boolean gameEnded(int pins) {
        if (frameCount == 9) {
            if (rolls > 2 || (rolls >= 2 && frameScore < 10))
                return true;
            frameScore += pins;
            score += pins;
            rolls++;
            wasLastFrameStrike(pins);
            return true;
        }
        return false;
    }

    private void wasLastFrameStrike(int pins) {
        if (lastFrameWasStrike) {
            strikeBonus += pins;
            lastFrameWasStrike = false;
            score += strikeBonus;
            strikeBonus = 0;
        }
    }
}