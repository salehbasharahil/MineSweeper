import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;
    private final int sideLength=5;
    private final int totalMines=1;

    @BeforeEach
    void setUp(){
        board=new Board(sideLength,totalMines);
    }

    @Test
    void TestInitializeAllSquaresNull() {

        Square[][] grid = board.getGrid();

        for (int row = 0; row < sideLength; row++) {
            for (int col = 0; col < sideLength; col++) {
                assertNotNull(grid[row][col], "Square at " + row + "," + col + " is null");
            }
        }
    }

    @Test
    void TestInitializeAllSquaresNotNull() {
        board.initializeAllSquares();

        Square[][] grid = board.getGrid();

        for (int row = 0; row < sideLength; row++) {
            for (int col = 0; col < sideLength; col++) {
                assertNotNull(grid[row][col], "Square at " + row + "," + col + " is not null");
            }
        }
    }



}
