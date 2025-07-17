import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void testSizeLowerThanMinIsInvalid() {
        assertFalse(validator.isValid(2));
    }

    @Test
    void testSizeAtMinIsValid() {
        assertTrue(validator.isValid(3));
    }

    @Test
    void testSizeWithinRangeIsValid() {
        assertTrue(validator.isValid(7));
    }

    @Test
    void testSizeAtMaxIsValid() {
        assertTrue(validator.isValid(10));
    }

    @Test
    void testSizeMoreThanMaxIsInvalid() {
        assertFalse(validator.isValid(11));
    }

    @Test
    public void testIsLessThan35PercentWithValidInput() {
        assertTrue(validator.isLessThan35percent(10, 20));
    }

    @Test
    public void testIsLessThan35PercentWithZeroAsInput() {
        assertFalse(validator.isLessThan35percent(0, 20));
    }

    @Test
    public void testIsMoreThan35PercentWithZeroInput() {
        assertTrue(validator.isLessThan35percent(3, 4));
    }

    @Test
    public void testIsLessThan35PercentWithNegativeNumber() {
        assertFalse(validator.isLessThan35percent(-1, 10));
    }

    @Test
    public void testInputIsValid() {
        assertTrue(validator.isValidInput("A1", 10));
    }

    @Test
    public void testInputIsInvalid() {
        assertFalse(validator.isValidInput("1A", 10));
    }

    @Test
    public void testInputIsSingleChar() {
        assertFalse(validator.isValidInput("A", 10));
    }

    @Test
    public void testInputIsSingleDigit() {
        assertFalse(validator.isValidInput("1", 10));
    }

    @Test
    public void testInputIsNegativeLength() {
        assertFalse(validator.isValidInput("A1", -1));
    }

}
