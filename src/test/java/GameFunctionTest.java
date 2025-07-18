import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class GameFunctionTest implements IGameVariables{

    private GameFunctions gameFunctions=new GameFunctions(this);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private IGameVariables mockVariables;

    @Override
    public int getSideLength() {
        return 0;
    }

    @Override
    public int getTotalNoMines() {
        return 0;
    }

    @Override
    public Square[][] grid() {
        return new Square[0][];
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void incrementCount() {

    }

    @Test
    void placeMinesTest(){

        assertDoesNotThrow(gameFunctions::placeMines);
    }


    @BeforeEach
    void setUp() {
        mockVariables = mock(IGameVariables.class);
    }

    @Test
    void testPlaceMinesNull() {
        int testNoMines=0;
        Square[][] square = new Square[mockVariables.getSideLength()][mockVariables.getSideLength()];
        for (int i = 0; i < mockVariables.getSideLength(); i++) {
            for (int j = 0; j < mockVariables.getSideLength(); j++) {
                if (square[i][j].isMine()) {
                    testNoMines++;
                }
            }
        }
        assertEquals(0, testNoMines, "Null");
    }

    @Test
    void testPlaceMinesNotNull() {

        int testNoMines=0;
        Square[][] square = new Square[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                square[i][j] = new Square();
            }
        }

        square[0][0].setMine(true);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (square[i][j].isMine()) {
                    testNoMines++;
                }
            }
        }
        assertEquals(1, testNoMines, "There are 1 mines placed");
    }

    @Test
    void printBoardTest(){

        assertDoesNotThrow(gameFunctions::printBoard);
    }

    @Test
    void testPrintBoardNullOutput() {
        System.setOut(new PrintStream(outContent));
        gameFunctions.printBoard();

        String expected =
                "Here is your minefield:\n" +
                        "   1 2 3\n" +
                        "A  - - -\n" +
                        "B  - - -\n";

        assertNotEquals(expected,outContent.toString());
    }
}
