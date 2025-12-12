# Bowling Game Solution

- Implementation lives in `src/main/java/com/windsurf/kata/BowlingGame.java`, parsing the scorecard into rolls and iterating frames to apply spare/strike bonuses.
- Tests in `src/test/java/com/windsurf/kata/BowlingGameTest.java` cover gutter games, open frames, spare and strike bonuses, and all sample scorecards.
- TDD cycles and coverage milestones were tracked in `TODO.md`.

## How to Run

Prerequisites: Java 21 and Maven.

Execute the test suite (uses a project-local Maven repo to avoid global writes):

```sh
mvn -Dmaven.repo.local=.m2/repository test
```
