import java.util.Random;
public class GameFunctions implements IGameFunctions {
    private final IGameVariables variables;
    private final Square[][] square;

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

        if(variables.count()==0) System.out.println("Here is your minefield:");
        if(variables.count()>1) System.out.println("Here is your updated minefield");

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
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        variables.incrementCount();

        if(variables.count()>1)System.out.println("This square contains "+currentSquare.getNeighboringMines()+" adjacent mines");

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

        int rowStart = Math.max(0, centerRow - 1);
        int rowEnd = Math.min(gridSize - 1, centerRow + 1);
        int colStart = Math.max(0, centerCol - 1);
        int colEnd = Math.min(gridSize - 1, centerCol + 1);

        for (int row = rowStart; row <= rowEnd; row++) {
            for (int col = colStart; col <= colEnd; col++) {

                if (row == centerRow && col == centerCol) continue;

                if (square[row][col].isMine()) {
                    mineCount++;
                }
            }
        }

        return mineCount;
    }

    public boolean revealCell(String input,int sideLength) {
        input = input.trim().toUpperCase();

        char rowChar = input.charAt(0);
        int col = Integer.parseInt(input.substring(1)) - 1;
        int row = rowChar - 'A';

        if (square[row][col].isRevealed()) {
            return true;
        }

        square[row][col].setRevealed(true);

        if (square[row][col].isMine()) {
            return false; // game over

        }

        if (square[row][col].getNeighboringMines() == 0) {
            for (int dRow = -1; dRow <= 1; dRow++) {
                for (int dCol = -1; dCol <= 1; dCol++) {
                    if (dRow != 0 || dCol != 0) {
                        int newRow = row + dRow;
                        int newCol = col + dCol;

                        if (newRow >= 0 && newRow < sideLength && newCol >= 0 && newCol < sideLength) {
                            String nextInput = (char) ('A' + newRow) + String.valueOf(newCol + 1);
                            revealCell(nextInput,sideLength);
                        }
                    }
                }
            }
        }

        return true;
    }
}

