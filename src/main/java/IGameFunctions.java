public interface IGameFunctions {
    void placeMines();

    void printBoard();

    void calculateNeighboringMines();

    boolean revealCell(String input, int sideLength);

}
