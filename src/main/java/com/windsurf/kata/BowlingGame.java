package com.windsurf.kata;

public class BowlingGame {

    public int score(String rolls) {
        int[] rollPins = parseRolls(rolls);
        int rollIndex = 0;
        int total = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollPins, rollIndex)) {
                total += 10 + strikeBonus(rollPins, rollIndex);
                rollIndex += 1;
            } else if (isSpare(rollPins, rollIndex)) {
                total += 10 + spareBonus(rollPins, rollIndex);
                rollIndex += 2;
            } else {
                total += framePins(rollPins, rollIndex);
                rollIndex += 2;
            }
        }

        return total;
    }

    private int[] parseRolls(String rolls) {
        int[] result = new int[rolls.length()];
        int i = 0;
        for (char roll : rolls.toCharArray()) {
            if (roll == '/') {
                result[i] = 10 - result[i - 1];
            } else {
                result[i] = pinsFor(roll);
            }
            i++;
        }
        return result;
    }

    private boolean isStrike(int[] rollPins, int rollIndex) {
        return rollPins[rollIndex] == 10;
    }

    private boolean isSpare(int[] rollPins, int rollIndex) {
        return framePins(rollPins, rollIndex) == 10;
    }

    private int strikeBonus(int[] rollPins, int rollIndex) {
        return rollPins[rollIndex + 1] + rollPins[rollIndex + 2];
    }

    private int spareBonus(int[] rollPins, int rollIndex) {
        return rollPins[rollIndex + 2];
    }

    private int framePins(int[] rollPins, int rollIndex) {
        return rollPins[rollIndex] + rollPins[rollIndex + 1];
    }

    private int pinsFor(char roll) {
        if (roll == '-') {
            return 0;
        }
        if (roll == 'X') {
            return 10;
        }
        if (Character.isDigit(roll)) {
            return Character.digit(roll, 10);
        }
        throw new IllegalArgumentException("Unsupported roll: " + roll);
    }
}
