package e1;

import e1.API.*;
import e1.decorator.*;
import e1.factory.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount account;

    private static final int EMPTY_BALANCE = 0;
    private static final int INITIAL_DEPOSIT = 1000;
    private static final int FIRST_WITHDRAW = 200;
    private static final int HIGHER_WITHDRAW = 1200;

    private static final int SILVER_FEE = 1;


    @BeforeEach
    void init(){
        this.account = new BankAccountFactoryImpl().createSilverAccount(SILVER_FEE);
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(EMPTY_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertEquals(INITIAL_DEPOSIT, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(FIRST_WITHDRAW);
        assertEquals(799, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(HIGHER_WITHDRAW));
    }

}
