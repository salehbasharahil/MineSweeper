# Minesweeper

Built on Java 17.

## Installation

Run command below in CLI

```bash
mvn exec:java -Dexec.mainClass="MineSweeper"
```

## Assumptions

1. The board design assumes the board is always square.
2. A minimum grid size of 3x3 to ensure the game has enough space for mines and meaningful play.
3. The number of mines must be less than the number of squares.

## Improvements

1. Difficulty settings, easy or hard;etc.
2. Timer/Countdown timer to increase pressure
3. UI/UX display such as using Swing library
