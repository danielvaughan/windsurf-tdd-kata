# Bowling Game Solution

This project implements the Bowling Game Kata in Java 21 using JUnit 5 for testing.

## Prerequisites

- Java 21
- Maven 3.x

## How to Run

To run the tests, execute the following command in the project root:

```bash
mvn test
```

## Implementation Details

The solution uses the standard "Uncle Bob" approach for the Bowling Game Kata:
- The `BowlingGame` class keeps track of rolls in an integer array.
- The `score()` method iterates through the frames (1 to 10) to calculate the total score.
- It handles Spares (10 pins in 2 rolls) and Strikes (10 pins in 1 roll) with their respective bonuses.
- The logic accounts for the bonus rolls in the 10th frame naturally without special "if last frame" logic, by iterating exactly 10 frames and accessing the lookahead rolls from the array.

## Project Structure

- `src/main/java/com/example/bowling/BowlingGame.java`: The main logic.
- `src/test/java/com/example/bowling/BowlingGameTest.java`: The test cases covering various scenarios.
