package com.example.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    Game game;

    @BeforeEach
    void setup() {
        game = new Game();
    }


    @Test
    @DisplayName("Checking score should return current score")
    void rollShouldAddToScore() {
        var result = game.score();

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Checking score after roll should return correct score")
    void scoreAfterRoll() {
        game.roll(3);

        var result = game.score();

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Checking score after rolling two times should return correct score")
    void scoreAfterMultipleRolls() {
        game.roll(3);
        game.roll(3);

        var result = game.score();

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Checking score after rolling a spare and then rolling again should add correct bonus")
    void scoreAfterSpare() {
        game.roll(7);
        game.roll(3);
        game.roll(6);

        var result = game.score();

        assertThat(result).isEqualTo(22);
    }

    @Test
    @DisplayName("Checking score after rolling three times should not add a bonus")
    void scoreAfterThreeRolls() {
        game.roll(7);
        game.roll(2);
        game.roll(6);

        var result = game.score();

        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("Checking score after rolling a strike should add correct bonus")
    void scoreAfterStrike() {
        game.roll(10);
        game.roll(6);
        game.roll(3);

        var result = game.score();

        assertThat(result).isEqualTo(28);
    }

    @Test
    @DisplayName("Checking score after rolling a strike then a spare should add correct bonus")
    void scoreAfterStrikeThenSpare() {
        game.roll(10);

        game.roll(6);
        game.roll(4);

        game.roll(4);

        var result = game.score();

        assertThat(result).isEqualTo(38);
    }

    @Test
    @DisplayName("Checking score after rolling a double strike should add correct bonus")
    void scoreAfterDoubleStrike() {
        game.roll(10);

        game.roll(10);

        game.roll(4);
        game.roll(0);

        var result = game.score();

        assertThat(result).isEqualTo(42);
    }

    @Test
    @DisplayName("Checking score after rolling two strike then a spare should add correct bonus")
    void scoreAfterDoubleStrikeFollowedBySpare() {
        game.roll(10);

        game.roll(10);

        game.roll(4);
        game.roll(6);

        game.roll(5);

        var result = game.score();

        assertThat(result).isEqualTo(64);
    }

    @Test
    @DisplayName("Checking score after two strikes then a spare then another strike should add correct bonus.")
    void scoreAfterTwoStrikeThenSpareThenStrike() {
        game.roll(10);

        game.roll(10);

        game.roll(4);
        game.roll(6);

        game.roll(10);

        game.roll(4);
        game.roll(4);

        var result = game.score();

        assertThat(result).isEqualTo(90);
    }

    @Test
    @DisplayName("Checking score after a game of bowling")
    void scoreAfterFullGame() {
        game.roll(10);

        game.roll(10);

        game.roll(4);
        game.roll(6);

        game.roll(10);

        game.roll(4);
        game.roll(4);

        game.roll(10);

        game.roll(7);
        game.roll(3);

        game.roll(5);
        game.roll(2);

        game.roll(7);
        game.roll(0);

        game.roll(10);
        game.roll(10);
        game.roll(10);

        var result = game.score();

        assertThat(result).isEqualTo(169);
    }

    @Test
    @DisplayName("Rolling after a full game should not affect score")
    void rollingAfterAFullGameShouldNotAffectScore() {
        game.roll(10);

        game.roll(10);

        game.roll(4);
        game.roll(6);

        game.roll(10);

        game.roll(4);
        game.roll(4);

        game.roll(10);

        game.roll(7);
        game.roll(3);

        game.roll(5);
        game.roll(2);

        game.roll(7);
        game.roll(0);

        game.roll(10);
        game.roll(10);
        game.roll(10);

        game.roll(10);

        var result = game.score();

        assertThat(result).isEqualTo(169);
    }

    @Test
    @DisplayName("Rolling after a full game should not affect score when not strike or spare in frame 10")
    void rollingAfterAFullGameShouldNotAffectScoreNoStrikeOrSpareLastFrame() {
        game.roll(10);

        game.roll(10);

        game.roll(4);
        game.roll(6);

        game.roll(10);

        game.roll(4);
        game.roll(4);

        game.roll(10);

        game.roll(7);
        game.roll(3);

        game.roll(5);
        game.roll(2);

        game.roll(7);
        game.roll(0);

        game.roll(4);
        game.roll(4);

        game.roll(10);

        var result = game.score();

        assertThat(result).isEqualTo(147);
    }

    @Test
    @DisplayName("Full game with only strikes until 10th frame should return correct score")
    void fullGameStrikesOnlyUntil10thFrame() {
        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(1);
        game.roll(1);

        var result = game.score();

        assertThat(result).isEqualTo(245);
    }

    @Test
    @DisplayName("Full game with only strike should return correct score")
    void fullGameStrikesOnly() {
        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);

        game.roll(10);
        game.roll(10);
        game.roll(10);

        var result = game.score();

        assertThat(result).isEqualTo(300);
    }

    @Test
    @DisplayName("Full game with only spares should return correct score")
    void fullGameSparesOnly() {
        game.roll(7);
        game.roll(3);

        game.roll(6);
        game.roll(4);

        game.roll(3);
        game.roll(7);

        game.roll(1);
        game.roll(9);

        game.roll(2);
        game.roll(8);

        game.roll(8);
        game.roll(2);

        game.roll(3);
        game.roll(7);

        game.roll(5);
        game.roll(5);

        game.roll(0);
        game.roll(10);

        game.roll(1);
        game.roll(9);
        game.roll(10);

        var result = game.score();

        assertThat(result).isEqualTo(139);
    }
}
