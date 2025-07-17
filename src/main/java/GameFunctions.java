import java.util.Random;

public class GameFunctions implements IGameFunctions {
    private final IGameVariables variables;
    private final Square[][] square;
    private int revealSafeSquareCount = 0;

    public GameFunctions(IGameVariables variables) {
        this.variables = variables;
        this.square = variables.grid();
    }

    @Override
    public void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < variables.getTotalNoMines()) {
            int row = random.nextInt(variables.getSideLength());
            int col = random.nextInt(variables.getSideLength());

            if (!square[row][col].isMine()) {
                square[row][col].setMine(true);
                minesPlaced++;
            }
        }
    }

    @Override
    public void printBoard() {

        Square currentSquare = null;

        if (variables.count() == 0) System.out.println("Here is your minefield:");
        if (variables.count() > 1) System.out.println("Here is your updated minefield");

        System.out.print("   ");
        for (int col = 0; col < variables.getSideLength(); col++) {
            System.out.print((col + 1) + " ");
        }
        System.out.println();

        for (int row = 0; row < variables.getSideLength(); row++) {
            char rowLabel = (char) ('A' + row);
            System.out.print(rowLabel + "  ");
            for (int col = 0; col < variables.getSideLength(); col++) {
                currentSquare = square[row][col];

                if (!currentSquare.isRevealed()) {
                    System.out.print("_ ");
                } else if (currentSquare.isMine()) {
                    System.out.print("* ");
                } else if (currentSquare.getNeighboringMines() > 0) {
                    System.out.print(currentSquare.getNeighboringMines() + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        variables.incrementCount();
    }

    @Override
    public void calculateNeighboringMines() {

        for (int row = 0; row < variables.getSideLength(); row++) {
            for (int col = 0; col < variables.getSideLength(); col++) {
                Square current = square[row][col];

                if (current.isMine()) continue;

                int mineCount = countAdjacentMines(row, col, variables.getSideLength());
                current.setNeighboringMines(mineCount);
            }
        }
    }

    private int countAdjacentMines(int centerRow, int centerCol, int gridSize) {
        int mineCount = 0;

        for (int dRow = -1; dRow <= 1; dRow++) {
            for (int dCol = -1; dCol <= 1; dCol++) {
                int row = centerRow + dRow;
                int col = centerCol + dCol;

                if (dRow == 0 && dCol == 0) continue;

                if (isValidPosition(row, col, gridSize) && square[row][col].isMine()) {
                    mineCount++;
                }
            }
        }

        return mineCount;
    }

    public int revealSquare(String input, int sideLength) {
        int[] position = parseInput(input);
        int row = position[0];
        int col = position[1];

        Square sq = square[row][col];

        if (sq.isRevealed()) {
            return sq.getNeighboringMines();
        }

        if (sq.isMine()) {
            sq.setRevealed(true);
            return -1; // game over
        }

        revealFrom(row, col, sideLength);
        return square[row][col].getNeighboringMines();
    }

    private void revealFrom(int row, int col, int sideLength) {
        if (!isValidPosition(row, col, sideLength)) return;

        Square sq = square[row][col];
        if (sq.isRevealed() || sq.isMine()) return;

        sq.setRevealed(true);
        revealSafeSquareCount++;

        if (sq.getNeighboringMines() == 0) {
            for (int dRow = -1; dRow <= 1; dRow++) {
                for (int dCol = -1; dCol <= 1; dCol++) {
                    if (dRow != 0 || dCol != 0) {
                        revealFrom(row + dRow, col + dCol, sideLength);
                    }
                }
            }
        }
    }

    private int[] parseInput(String input) {
        input = input.trim().toUpperCase();
        char rowChar = input.charAt(0);
        int col = Integer.parseInt(input.substring(1)) - 1;
        int row = rowChar - 'A';
        return new int[]{row, col};
    }

    private boolean isValidPosition(int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public boolean hasPlayerWonCheck () {
            int totalSafeSquares = variables.getSideLength() * variables.getSideLength() - variables.getTotalNoMines();
            return revealSafeSquareCount == totalSafeSquares;
        }
    }



