package Activity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Activity2 {

    @Test
    public void notEnoughFunds(){
        BankAccount acc1 = new BankAccount(10);
        assertThrows(NotEnoughFundsException.class, () -> acc1.withdraw(20));
    }


    @Test
    public void enoughFunds(){
        BankAccount acc2 = new BankAccount(100);
        assertDoesNotThrow(() -> acc2.withdraw(100));
    }

}

