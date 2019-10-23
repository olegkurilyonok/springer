package paycore.facade;

import paycore.facade.exceptions.NotEnoughMoney;
import paycore.facade.utils.Account;

import java.math.BigDecimal;

public class TransferServiceFacade {
    private PaymentCenter paymentCenter = PaymentCenter.getInstance();
    private ProcessingCenter processingCenter = ProcessingCenter.getInstance();

    public void transfer(Account account, Card card, BigDecimal amount) {
        if (!processingCenter.checkExisted(account.getAccountNumber(), card)) {
            processingCenter.addCardToAccount(account, card);
        }

        String transactionId = null;
        try {
            transactionId = paymentCenter.startTransaction(account, card, amount);
            paymentCenter.completedTransaction(transactionId);
        } catch (NotEnoughMoney e) {
            paymentCenter.filedTransaction(e.getTransactionId());
            System.out.println("**** No enough money on card balance ****");
        }
    }

    public void showHistory() {
        paymentCenter.showTransactionHistory();
    }

    public void showStatistic() {
        paymentCenter.showTransactionStatistic();
    }

    public void showCardStatistic() {
        processingCenter.showCardStatistic();
    }
}
