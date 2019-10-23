package paycore.facade;

import paycore.facade.exceptions.NotEnoughMoney;
import paycore.facade.utils.Account;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentCenter {
    private static PaymentCenter instance = null;
    private ProcessingCenter processingCenter = ProcessingCenter.getInstance();
    private HashMap<String, Transaction> transactionStorage = new HashMap<>();

    private PaymentCenter() {
    }

    public static PaymentCenter getInstance() {
        if (instance == null) {
            instance = new PaymentCenter();
        }
        return instance;
    }

    public String startTransaction(Account account, Card card, BigDecimal paymentAmount) throws NotEnoughMoney {
        Transaction transaction = new Transaction(String.valueOf(System.currentTimeMillis()),
                Transaction.TransactionState.STARTED,
                account.getAccountNumber(),
                paymentAmount);
        transactionStorage.put(transaction.getTransactionId(), transaction);
        System.out.println("Transaction with id [" + transaction.getTransactionId() + "] STARTED!");

        try {
            Card cardForPayment = validateAndChangePaymentCard(account, card, paymentAmount);
            cardForPayment.setBalance(cardForPayment.getBalance().subtract(paymentAmount));
            transaction.setCardNumber(cardForPayment.getCardNumber());
        } catch (NotEnoughMoney e) {
            e.setTransactionId(transaction.getTransactionId());
            throw e;
        }
        return transaction.getTransactionId();
    }

    private Card validateAndChangePaymentCard(Account account, Card card, BigDecimal paymentAmount) throws NotEnoughMoney {
        if (!enoughMoney(card, paymentAmount)) {
            System.out.println("Try found card for payment...");
            List<Card> collect = account.getCards()
                    .stream()
                    .filter(Card::isAllowedForPayment)
                    .collect(Collectors.toList());

            for (Card allowedForPaymentCard : collect) {
                System.out.println("Try change card to [" + allowedForPaymentCard.getCardNumber() + "]");
                if (enoughMoney(allowedForPaymentCard, paymentAmount)) {
                    return allowedForPaymentCard;
                }
            }
            throw new NotEnoughMoney();
        }
        return card;
    }

    private boolean enoughMoney(Card card, BigDecimal paymentAmount) {
        return processingCenter.enoughMoneyForPayment(card.getBalance(), paymentAmount);
    }

    public void completedTransaction(String transactionId) {
        transactionStorage.get(transactionId).setState(Transaction.TransactionState.COMPLETED);
        System.out.println("Transaction with id [" + transactionId + "] COMPLETED!");
    }

    public void terminateTransaction(String transactionId) {
        transactionStorage.get(transactionId).setState(Transaction.TransactionState.TERMINATED);
        System.out.println("Transaction with id [" + transactionId + "] TERMINATE!");
    }

    public void filedTransaction(String transactionId) {
        System.out.println(transactionId);
        transactionStorage.get(transactionId).setState(Transaction.TransactionState.FILED);
        System.out.println("Transaction with id [" + transactionId + "] FILED!");
    }

    public void showTransactionHistory() {
        System.out.println("=========== Transaction history ===========");
        transactionStorage.values().forEach(System.out::println);
    }

    public void showTransactionStatistic() {
        System.out.println("=================================");
        System.out.println("Calculate all transaction amounts");


        Double successAmount = transactionStorage.values()
                .stream()
                .filter(x -> x.getState().equals(Transaction.TransactionState.COMPLETED))
                .map(Transaction::getAmount).mapToDouble(BigDecimal::doubleValue).sum();

        Double filedAmount = transactionStorage.values()
                .stream()
                .filter(x -> x.getState().equals(Transaction.TransactionState.FILED))
                .map(Transaction::getAmount).mapToDouble(BigDecimal::doubleValue).sum();

        System.out.println("AMOUNT BY COMPLETED: " + successAmount);
        System.out.println("AMOUNT BY FILED: " + filedAmount);
        System.out.println("");
        System.out.println("=========== Transaction statistic ===========");
        System.out.println("COMPLETED:" + transactionStorage.values()
                .stream()
                .filter(transaction -> transaction.getState().equals(Transaction.TransactionState.COMPLETED))
                .count());

        System.out.println("FILED:" + transactionStorage.values()
                .stream()
                .filter(transaction -> transaction.getState().equals(Transaction.TransactionState.FILED))
                .count());
    }

    public void cleanTerminatedTransaction() {
        transactionStorage.entrySet().removeIf(transaction -> transaction.getValue().getState().equals(Transaction.TransactionState.TERMINATED));
    }

}
