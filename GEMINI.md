# GEMINI.md - TDD Bowling Game Kata

You are solving the Bowling Game kata described in EXERCISE.md using Test-Driven Development (TDD).

## Your Task

Implement a complete solution for the bowling game scoring system. You must follow TDD principles throughout, writing tests before implementation code.

## TDD Process

Follow the red-green-refactor cycle:

1. **Red**: Write a small, failing test that describes one aspect of the behavior
2. **Green**: Write the minimal code required to make the test pass
3. **Refactor**: Improve the code structure while keeping tests passing

Repeat these steps until the full problem is solved.

## Principles to Follow

- **Take small steps**: Each iteration should be small enough that you can reach green quickly (all tests passing)
- **Stick to the cycle**: Complete red-green-refactor before starting the next test
- **Separate concerns**: Keep feature changes and refactoring changes in separate iterations
- **Let code evolve**: As tests become more specific, your implementation should become more generic
- **Don't refactor in red**: If a failing test requires large changes, remove the test, refactor while green, then write the test again
- **Minimal implementation**: Write only the code needed to pass each test, not anticipatory code for future features

## Starting Point

1. Create a test file to hold your test cases
2. Create the implementation file(s) for the bowling game scorer
3. Begin with the simplest test case (all gutter balls or simple sequential rolls)

## Success Criteria

Your implementation is complete when:
- All test cases from the EXERCISE.md examples pass:
    - `12345123451234512345` → score of 60
    - `XXXXXXXXXXXX` → perfect game score of 300
    - `9-9-9-9-9-9-9-9-9-9-` → score of 90
    - `5/5/5/5/5/5/5/5/5/5/5` → score of 150
- Your code is well-structured and follows TDD principles
- Tests are comprehensive and validate the scoring logic

## Progress Tracking

Use the todo list to track your progress through each red-green-refactor cycle. Mark each cycle as completed when tests pass and any refactoring is done.

Go ahead and start solving the kata using TDD!
