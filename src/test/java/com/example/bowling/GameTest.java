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
    @DisplayName("Score should return current score")
    void rollShouldAddToScore() {
        var result = game.score();

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Score after roll")
    void scoreAfterRoll() {
        game.roll(3);

        var result = game.score();

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Score after rolling two times")
    void scoreAfterMultipleRolls() {
        game.roll(3);
        game.roll(3);

        var result = game.score();

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Spare bonus")
    void scoreAfterSpare() {
        game.roll(7);
        game.roll(3);
        game.roll(6);

        var result = game.score();

        assertThat(result).isEqualTo(22);
    }

    @Test
    @DisplayName("Score after three rolls should not add bonus")
    void scoreAfterThreeRolls() {
        game.roll(7);
        game.roll(2);
        game.roll(6);

        var result = game.score();

        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("Strike bonus")
    void scoreAfterStrike() {
        game.roll(10);
        game.roll(6);
        game.roll(3);

        var result = game.score();

        assertThat(result).isEqualTo(28);
    }

    @Test
    @DisplayName("Score after strike then spare")
    void scoreAfterStrikeThenSpare() {
        game.roll(10);

        game.roll(6);
        game.roll(4);

        game.roll(4);

        var result = game.score();

        assertThat(result).isEqualTo(38);
    }

    @Test
    @DisplayName("Correct bonus after double strike")
    void scoreAfterDoubleStrike() {
        game.roll(10);

        game.roll(10);

        game.roll(4);
        game.roll(0);

        var result = game.score();

        assertThat(result).isEqualTo(42);
    }

    @Test
    @DisplayName("Double strike then spare")
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
    @DisplayName("Double strikes then spare then another strike")
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
    @DisplayName("Score after full game")
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
    @DisplayName("Roll after game")
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
    @DisplayName("Rolling after a full game, no spare/strike in 10th frame")
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
    @DisplayName("Only strikes until 10th frame should add correct bonus")
    void fullGameStrikesOnlyUntil10thFrame() {
        rolls(9, 10);

        game.roll(1);
        game.roll(1);

        var result = game.score();

        assertThat(result).isEqualTo(245);
    }

    @Test
    @DisplayName("Only strikes should return 300")
    void fullGameStrikesOnly() {
        rolls(12, 10);

        var result = game.score();

        assertThat(result).isEqualTo(300);
    }

    @Test
    @DisplayName("Only spares")
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

    private void rolls(int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }
}
