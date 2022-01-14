package com.example.bowling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    @DisplayName("Checking score should return current score")
    void rollShouldAddToScore() {
        Game game = new Game();

        var result = game.score();

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Checking score after roll should return correct score")
    void scoreAfterRoll() {
        Game game = new Game();

        game.roll(3);

        var result = game.score();

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Checking score after rolling two times should return correct score")
    void scoreAfterMultipleRolls() {
        Game game = new Game();

        game.roll(3);
        game.roll(3);

        var result = game.score();

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Checking score after rolling a spare and then rolling again should add correct bonus")
    void scoreAfterSpare() {
        Game game = new Game();

        game.roll(7);
        game.roll(3);
        game.roll(6);

        var result = game.score();

        assertThat(result).isEqualTo(22);
    }

    @Test
    @DisplayName("Checking score after rolling three times should not add a bonus")
    void scoreAfterThreeRolls() {
        Game game = new Game();

        game.roll(7);
        game.roll(2);
        game.roll(6);

        var result = game.score();

        assertThat(result).isEqualTo(15);
    }
}
