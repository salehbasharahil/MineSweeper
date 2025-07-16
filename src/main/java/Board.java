public class Board implements IGameVariables{
    private final int sideLength;
    private final int totalNoMines;
    private Square[][] grid;
    private int count=0;
    public Board(int sideLength, int totalMines) {
        this.sideLength = sideLength;
        this.totalNoMines = totalMines;
        this.grid=new Square[sideLength][sideLength];

        initializeAllCells();
    }

    public int getSideLength() {
        return sideLength;
    }

    public int getTotalNoMines() {
        return totalNoMines;
    }
    @Override
    public Square[][] grid() {
        return grid;
    }

    @Override
    public int count() {
        return count;
    }
    public void incrementCount() {
        count++;
    }

    @Override
    public void resetCount() {
        count = 0;
    }

    public void initializeAllCells() {
        for (int row = 0; row < sideLength; row++) {
            for (int col = 0; col < sideLength; col++) {
                grid[row][col] = new Square();
            }
        }
    }
}
