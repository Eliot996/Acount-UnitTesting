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

    @Test
    void testWithdraw_WithNegativeNumbers(){
        // arrange
        Account account = new Account(1, "guler", 11);
        int toWithdraw = -10;

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(toWithdraw));
    }

    @Test
    void testWithdraw_WithLargerThanBalanceNumbers(){
        // arrange
        Account account = new Account(1, "guler",9);
        int toWithdraw = 10;

        // Act & Assert
        assertThrows(TooLowBalanceException.class,
                () -> account.withdraw(toWithdraw));
    }

    @Test
    void testWithdraw_WithSmallerThanBalanceNumbers() {
        // arrange
        Account account = new Account(1, "guler", 10);
        int toWithdraw = 9;
        int expected = 1;

        // Act
        int result = account.withdraw(toWithdraw);

        // Assert
        assertEquals(expected, result);
    }
}