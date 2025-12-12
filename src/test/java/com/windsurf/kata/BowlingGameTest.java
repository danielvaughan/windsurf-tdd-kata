package com.windsurf.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BowlingGameTest {

    @Test
    void scoresZeroForGutterGame() {
        var game = new BowlingGame();

        int score = game.score("--------------------"); // 20 rolls of misses

        assertEquals(0, score);
    }

    @Test
    void sumsPinsWhenNoBonusesApply() {
        var game = new BowlingGame();

        int score = game.score("12345123451234512345");

        assertEquals(60, score);
    }

    @Test
    void addsNextRollForSpareBonus() {
        var game = new BowlingGame();

        int score = game.score("5/3-----------------");

        assertEquals(16, score);
    }

    @Test
    void addsNextTwoRollsForStrikeBonus() {
        var game = new BowlingGame();

        int score = game.score("X34----------------");

        assertEquals(24, score);
    }

    @ParameterizedTest
    @CsvSource({
            "12345123451234512345, 60",
            "XXXXXXXXXXXX, 300",
            "9-9-9-9-9-9-9-9-9-9-, 90",
            "5/5/5/5/5/5/5/5/5/5/5, 150"
    })
    void scoresProvidedExamples(String scorecard, int expectedScore) {
        var game = new BowlingGame();

        int score = game.score(scorecard);

        assertEquals(expectedScore, score);
    }
}
