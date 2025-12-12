package com.example.bowling;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    private BowlingGame game;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        game = new BowlingGame();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }

    @Test
    void testGutterGame() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    void testAllOnes() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    void testOneSpare() {
        game.roll(5);
        game.roll(5); // Spare
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    void testOneStrike() {
        game.roll(10); // Strike
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    void testPerfectGame() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    @Test
    void testSampleGame1() {
        // 12345123451234512345
        int[] rolls = {1,2, 3,4, 5,1, 2,3, 4,5, 1,2, 3,4, 5,1, 2,3, 4,5};
        for (int pins : rolls) {
            game.roll(pins);
        }
        assertEquals(60, game.score());
    }

    @Test
    void testSampleGame2() {
        // 9-9-9-9-9-9-9-9-9-9-
        for (int i = 0; i < 10; i++) {
            game.roll(9);
            game.roll(0);
        }
        assertEquals(90, game.score());
    }

    @Test
    void testSampleGame3() {
        // 5/5/5/5/5/5/5/5/5/5/5
        rollMany(21, 5);
        assertEquals(150, game.score());
    }
}
