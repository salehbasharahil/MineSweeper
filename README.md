# Minesweeper

This is the classic game of Minesweeper. There are mines hidden under a grid of squares. If you click on a mine you lose however if you manage to flip open all the safe squares without clicking on the mines, you won.

Built on Java 17.

# Game Play

1. Input a number for the length of the grid
2. Input a number for the number of mines (the higher, the harder!)
3. Begin selecting safe squares
4. A number on a square denotes the number of adjacent mines
5. Continue until you clicked on a mine or until you flipped all the safe squares

## Installation

Run command below in CLI

```bash
mvn exec:java -Dexec.mainClass="MineSweeper"
```

## Assumptions

1. The board design assumes the board is always square.
2. A minimum grid size of 3x3 to ensure the game has enough space for mines and meaningful play.
3. The number of mines must be less than 35% of number of squares.

## Improvements

1. Difficulty settings, easy or hard;etc.
2. Timer/Countdown timer to increase pressure
3. UI/UX display such as using Swing library
4. Toggle the depth of reveal from square selected
