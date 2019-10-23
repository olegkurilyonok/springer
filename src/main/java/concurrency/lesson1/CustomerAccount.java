package concurrency.lesson1;

import java.math.BigDecimal;

public class CustomerAccount {
    private BigDecimal balance;


    public CustomerAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public void decreaseBalance(BigDecimal amount) {
        this.balance = balance.subtract(amount);
    }

    public void increaseBalance(BigDecimal amount) {
        this.balance = balance.add(amount);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
