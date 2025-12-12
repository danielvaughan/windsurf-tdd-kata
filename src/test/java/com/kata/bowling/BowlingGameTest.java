package com.kata.bowling;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    void gutterGame() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    void allOnes() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertThat(game.score()).isEqualTo(20);
    }

    @Test
    void oneSpare() {
        BowlingGame game = new BowlingGame();
        game.roll(5);
        game.roll(5);
        game.roll(3);
        for (int i = 0; i < 17; i++) {
            game.roll(0);
        }
        assertThat(game.score()).isEqualTo(16);
    }

    @Test
    void oneStrike() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(3);
        game.roll(4);
        for (int i = 0; i < 16; i++) {
            game.roll(0);
        }
        assertThat(game.score()).isEqualTo(24);
    }

    @Test
    void perfectGame() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
        assertThat(game.score()).isEqualTo(300);
    }

    @Test
    void sampleGame1() {
        // 12345123451234512345 -> 60
        BowlingGame game = new BowlingGame();
        int[] rolls = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
        for (int pins : rolls) {
            game.roll(pins);
        }
        assertThat(game.score()).isEqualTo(60);
    }

    @Test
    void sampleGame2() {
        // 9-9-9-9-9-9-9-9-9-9- -> 90
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 10; i++) {
            game.roll(9);
            game.roll(0);
        }
        assertThat(game.score()).isEqualTo(90);
    }

    @Test
    void sampleGame3() {
        // 5/5/5/5/5/5/5/5/5/5/5 -> 150
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 10; i++) {
            game.roll(5);
            game.roll(5);
        }
        game.roll(5);
        assertThat(game.score()).isEqualTo(150);
    }
}
