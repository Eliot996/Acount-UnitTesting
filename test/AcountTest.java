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

    @Test
    void testTransfer_WithSmallerThanBalanceNumbers_FromSide() {
        // arrange
        Account accountFrom = new Account(1, "Guler", 10);
        Account accountTarget = new Account(1, "Mathias", 10);
        int toWithdraw = 4;
        int expected = 1;

        // Act
        int result = accountFrom.transfer(toWithdraw, accountTarget);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testTransfer_WithSmallerThanBalanceNumbers_TargetSide() {
        // arrange
        Account accountFrom = new Account(1, "Guler", 10);
        Account accountTarget = new Account(1, "Mathias", 10);
        int toWithdraw = 4;
        int expected = 14;

        // Act
        accountFrom.transfer(toWithdraw, accountTarget);
        int result = accountTarget.getBalance();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testTransfer_WithlargerThanBalanceNumbers() {
        // arrange
        Account accountFrom = new Account(1, "Guler", 10);
        Account accountTarget = new Account(1, "Mathias", 10);
        int toWithdraw = 10;

        // Act & Assert
        assertThrows(TooLowBalanceException.class,
                () -> accountFrom.transfer(toWithdraw, accountTarget));
    }

    @Test
    void testTransfer_WithNegativeNumbers() {
        // arrange
        Account accountFrom = new Account(1, "Guler", 10);
        Account accountTarget = new Account(1, "Mathias", 10);
        int toWithdraw = -5;

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> accountFrom.transfer(toWithdraw, accountTarget));
    }

    @Test
    void testTransfer_WithTargetIsNull() {
        // arrange
        Account accountFrom = new Account(1, "Guler", 10);
        Account accountTarget = null;
        int toWithdraw = -5;

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> accountFrom.transfer(toWithdraw, accountTarget));
    }
}