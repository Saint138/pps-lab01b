package e1;

public class CanWithdrawDecorator extends BankAccountDecorator{

    public CanWithdrawDecorator(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(int amount) {
        if(this.getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds");
        } else {
            super.withdraw(amount);
        }
    }
}
