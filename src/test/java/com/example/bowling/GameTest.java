package com.example.bowling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    @DisplayName("score should return current score")
    void rollShouldAddToScore() {
        Game game = new Game();

        var result = game.score();

        assertThat(result).isEqualTo(0);
    }
}
