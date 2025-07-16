import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void testSizeBelowMinIsInvalid() {
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
    void testSizeAboveMaxIsInvalid() {
        assertFalse(validator.isValid(11));
    }
}
