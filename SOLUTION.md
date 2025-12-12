# Bowling Game Kata - Solution

## Overview

This is a complete implementation of the Bowling Game scoring system using Test-Driven Development (TDD) principles with Java 21 and JUnit 5.

## Project Structure

```
windsurf-tdd-kata/
├── pom.xml
├── src/
│   ├── main/java/com/bowling/
│   │   └── BowlingGame.java
│   └── test/java/com/bowling/
│       └── BowlingGameTest.java
```

## Implementation Details

### BowlingGame.java

The `BowlingGame` class implements the scoring logic for American Ten-Pin Bowling:

- **Gutter balls (0 pins)**: Score as 0
- **Open frames**: Score is the sum of the two rolls
- **Spares (/)**: Score is 10 plus the next roll
- **Strikes (X)**: Score is 10 plus the next two rolls
- **Perfect game**: All strikes result in a score of 300

### BowlingGameTest.java

The test suite includes:

1. **Unit tests** for individual scenarios:
   - Gutter game (all misses)
   - All ones
   - Single spare
   - Single strike
   - Perfect game

2. **Integration tests** for all example scenarios from the exercise:
   - `12345123451234512345` → score of 60
   - `XXXXXXXXXXXX` → score of 300 (perfect game)
   - `9-9-9-9-9-9-9-9-9-9-` → score of 90
   - `5/5/5/5/5/5/5/5/5/5/5` → score of 150

## How to Run

### Run all tests:
```bash
mvn clean test
```

### Run only the bowling game tests:
```bash
mvn clean test -Dtest=BowlingGameTest
```

### Run with verbose output:
```bash
mvn clean test -Dtest=BowlingGameTest -v
```

### Build the project:
```bash
mvn clean compile
```

## Test Results

All 9 tests pass successfully:

```
Tests run: 9, Failures: 0, Errors: 0, Skipped: 0
```

### Test Details

| Test Name | Description | Status |
|-----------|-------------|--------|
| testGutterGame | 20 rolls of 0 pins → 0 | ✓ |
| testAllOnes | 20 rolls of 1 pin → 20 | ✓ |
| testOneSpare | 5 + 5 (spare) + 3 + 17×0 → 16 | ✓ |
| testOneStrike | 10 (strike) + 3 + 4 + 16×0 → 24 | ✓ |
| testPerfectGame | 12 strikes (10 frames + 2 bonus) → 300 | ✓ |
| testScenarioAllOnesAndTwos | 12345123451234512345 → 60 | ✓ |
| testScenarioPerfectGame | XXXXXXXXXXXX → 300 | ✓ |
| testScenarioHeartbreak | 9-9-9-9-9-9-9-9-9-9- → 90 | ✓ |
| testScenarioAllSpares | 5/5/5/5/5/5/5/5/5/5/5 → 150 | ✓ |

## Key Implementation Features

### TDD Process

The solution was developed following the red-green-refactor cycle:

1. **Red**: Write a failing test for a new feature
2. **Green**: Implement minimal code to make the test pass
3. **Refactor**: Clean up the code while keeping tests passing

### Scorecard Parser

The test helper method `rollScorecard()` converts scorecard notation to individual rolls:
- `X` = Strike (10 pins)
- `/` = Spare (completes 10 pins)
- `-` = Miss (0 pins)
- `1-9` = Number of pins knocked down

## Technology Stack

- **Java 21**: Modern Java features and improved performance
- **JUnit 5**: Latest testing framework with Jupiter engine
- **Maven 3.x**: Build and dependency management

## Dependencies

- junit-jupiter-api (5.10.0)
- junit-jupiter-engine (5.10.0)

## Notes

- The implementation assumes valid input (as per exercise requirements)
- No input validation is performed
- The solution handles all 10 frames plus bonus rolls in the 10th frame
- The internal representation uses an array of rolls for simplicity and efficiency
