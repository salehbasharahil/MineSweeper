import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;

public class InputTest {

    @Test
    void testGetValidUserInput() {
        String simulatedInput = "5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ConsoleInputReader consoleInputReader = new ConsoleInputReader();

        int result = consoleInputReader.readInt();

        assertEquals(5, result);
    }

    @Test
    void testReadResponseNegative(){
        String simulatedInput = "a\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        assertFalse(consoleInputReader.readResponse());

    }

    @Test
    void testReadResponsePositive(){
        String simulatedInput = "a1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        assertTrue(consoleInputReader.readResponse());

    }

    @Test
    void testReadResponseNotNull(){
        String simulatedInput = "aa\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        assertNotNull(consoleInputReader.readResponse());

    }
}