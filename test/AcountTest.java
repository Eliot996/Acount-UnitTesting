import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcountTest {

    @Test
    void testInsert_PositiveNumber() {
        // Arrange
        Account account = new Account(1, "guler", 0);
        int toAdd = 10;
        int expected = 10;

        // Act
        int result = account.insert(toAdd);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testInsert_PositiveNumber_WithPreexistingBalance() {
        // Arrange
        Account account = new Account(1, "guler", 100);
        int toAdd = 10;
        int expected = 110;

        // Act
        int result = account.insert(toAdd);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testInsert_NegativeNumber() {
        // Arrange
        Account account = new Account(1, "guler", 0);
        int toAdd = -10;

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> account.insert(toAdd));
    }
}