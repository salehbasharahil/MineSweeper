public interface IGameFunctions {

    void placeMines();

    void printBoard();

    void calculateNeighboringMines();

    int revealSquare(String input, int sideLength);

    boolean hasPlayerWonCheck();

}
