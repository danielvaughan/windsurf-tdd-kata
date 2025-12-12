package com.bowling;

public class BowlingGame {
    private int[] rolls = new int[21];
    private int rollIndex = 0;

    public void roll(int pins) {
        rolls[rollIndex++] = pins;
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;

        for (int frameIndex = 0; frameIndex < 10; frameIndex++) {
            if (rolls[rollIndex] == 10) {
                // Strike: 10 + next two rolls
                score += 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
                rollIndex += 1;
            } else if (rolls[rollIndex] + rolls[rollIndex + 1] == 10) {
                // Spare: 10 + next roll
                score += 10 + rolls[rollIndex + 2];
                rollIndex += 2;
            } else {
                score += rolls[rollIndex] + rolls[rollIndex + 1];
                rollIndex += 2;
            }
        }

        return score;
    }
}
