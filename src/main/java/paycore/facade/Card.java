package paycore.facade;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

@Builder
public class Card {
    private String cardNumber;
    private Date expireDate;
    private boolean active;
    private BigDecimal balance;
    private BigDecimal initialBalance;
    private boolean allowedForPayment = true;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isAllowedForPayment() {
        return allowedForPayment;
    }

    public void setAllowedForPayment(boolean allowedForPayment) {
        this.allowedForPayment = allowedForPayment;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    @Override
    public String toString() {
        return "cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                ", initialBalance=" + initialBalance +
                ", allowedForPayment=" + allowedForPayment;
    }
}
