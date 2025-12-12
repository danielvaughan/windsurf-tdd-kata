package com.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    private BowlingGame game;

    @BeforeEach
    void setUp() {
        game = new BowlingGame();
    }

    @Test
    void testGutterGame() {
        // All rolls are misses (0 pins)
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    void testAllOnes() {
        // Roll 1 pin on each roll
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    @Test
    void testOneSpare() {
        // A spare: 5 + 5 = 10, plus next roll of 3
        game.roll(5);
        game.roll(5); // spare
        game.roll(3);
        // Complete remaining frames with zeros
        for (int i = 0; i < 17; i++) {
            game.roll(0);
        }
        assertEquals(16, game.score()); // 10 + 3 + (3 + 0) + rest = 16
    }

    @Test
    void testOneStrike() {
        // A strike: 10 pins on first roll, then 3 and 4 on next rolls
        game.roll(10); // strike
        game.roll(3);
        game.roll(4);
        // Complete remaining frames with zeros
        for (int i = 0; i < 16; i++) {
            game.roll(0);
        }
        assertEquals(24, game.score()); // 10 + 3 + 4 + (3 + 4) + rest = 24
    }

    @Test
    void testPerfectGame() {
        // All strikes: 12 rolls of 10 (10 frames + 2 bonus rolls)
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
        assertEquals(300, game.score());
    }

    @Test
    @DisplayName("Example: 12345123451234512345 → 60")
    void testScenarioAllOnesAndTwos() {
        rollScorecard("12345123451234512345");
        assertEquals(60, game.score());
    }

    @Test
    @DisplayName("Example: XXXXXXXXXXXX → 300")
    void testScenarioPerfectGame() {
        rollScorecard("XXXXXXXXXXXX");
        assertEquals(300, game.score());
    }

    @Test
    @DisplayName("Example: 9-9-9-9-9-9-9-9-9-9- → 90")
    void testScenarioHeartbreak() {
        rollScorecard("9-9-9-9-9-9-9-9-9-9-");
        assertEquals(90, game.score());
    }

    @Test
    @DisplayName("Example: 5/5/5/5/5/5/5/5/5/5/5 → 150")
    void testScenarioAllSpares() {
        rollScorecard("5/5/5/5/5/5/5/5/5/5/5");
        assertEquals(150, game.score());
    }

    private void rollScorecard(String scorecard) {
        int i = 0;
        for (int frame = 0; frame < 10 && i < scorecard.length(); frame++) {
            char roll = scorecard.charAt(i++);

            if (roll == 'X') {
                game.roll(10);
            } else if (roll == '/') {
                int firstRoll = parseRoll(scorecard.charAt(i - 2));
                game.roll(10 - firstRoll);
            } else {
                game.roll(parseRoll(roll));
                if (i < scorecard.length() && frame < 9) {
                    roll = scorecard.charAt(i++);
                    if (roll == '/') {
                        int firstRoll = parseRoll(scorecard.charAt(i - 2));
                        game.roll(10 - firstRoll);
                    } else {
                        game.roll(parseRoll(roll));
                    }
                }
            }
        }

        // Handle bonus rolls in the 10th frame
        while (i < scorecard.length()) {
            char roll = scorecard.charAt(i++);
            if (roll == 'X') {
                game.roll(10);
            } else if (roll == '/') {
                int firstRoll = parseRoll(scorecard.charAt(i - 2));
                game.roll(10 - firstRoll);
            } else {
                game.roll(parseRoll(roll));
            }
        }
    }

    private int parseRoll(char c) {
        if (c == '-') {
            return 0;
        }
        return Character.getNumericValue(c);
    }
}
