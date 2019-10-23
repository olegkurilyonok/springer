package paycore.facade;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Transaction {
    private String transactionId;
    private TransactionState state;
    private Date transactionDate;
    private String cardNumber;
    private String accountNumber;
    private BigDecimal amount;

    public Transaction(String transactionId, TransactionState state, String accountNumber, BigDecimal amount) {
        this.transactionId = transactionId;
        this.state = state;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public enum TransactionState {
        STARTED,
        TERMINATED,
        FILED,
        COMPLETED
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", state=" + state +
                ", transactionDate=" + transactionDate +
                ", cardNumber='" + cardNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
