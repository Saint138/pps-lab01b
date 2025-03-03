package e1.API;

public interface BankAccount {

    int getBalance();

    void deposit(int amount);

    void withdraw(int amount);
}
