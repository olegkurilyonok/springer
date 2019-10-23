package paycore.facade;

import paycore.facade.utils.Account;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class ProcessingCenter {
    private static ProcessingCenter instance;
    private HashMap<String, Account> accountStorage = new HashMap<>();

    private ProcessingCenter() {
    }

    public static ProcessingCenter getInstance() {
        if (instance == null) {
            instance = new ProcessingCenter();
        }
        return instance;
    }

    public Account addCardToAccount(Account account, Card card) {
        Account existedAccount = accountStorage.get(account.getAccountNumber());
        if (existedAccount != null && !existedAccount.getCards().contains(card)) {
            existedAccount.getCards().add(card);
        } else {
            Account createdAccount = new Account("Owner", getUniqueNumber());
            createdAccount.getCards().add(card);
            accountStorage.put(createdAccount.getAccountNumber(), createdAccount);
            return createdAccount;
        }
        System.out.println("Add card with id [" + card.getCardNumber() + "] to storage");
        return existedAccount;
    }

    public Account createAccountAndAddCard(Card card) {
        Account createdAccount = new Account("Owner", getUniqueNumber());
        createdAccount.getCards().add(card);
        accountStorage.put(createdAccount.getAccountNumber(), createdAccount);

        System.out.println("Add card with id [" + card.getCardNumber() + "] to storage");
        return createdAccount;
    }

    public Account createAccount() {
        Account createdAccount = new Account("Owner", getUniqueNumber());
        accountStorage.put(createdAccount.getAccountNumber(), createdAccount);

        System.out.println("Add account with id [" + createdAccount.getAccountNumber() + "] to storage");
        return createdAccount;
    }

    private synchronized String getUniqueNumber() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.valueOf(System.currentTimeMillis());
    }


    public boolean checkExisted(String accountNumber, Card card) {
        return accountStorage.get(accountNumber) != null && accountStorage.get(accountNumber).getCards().contains(card);
    }

    public boolean enoughMoneyForPayment(BigDecimal balanceAmount, BigDecimal paymentAmount) {
        System.out.println("balance = " + balanceAmount + " | payment = " + paymentAmount);
        System.out.println(balanceAmount.subtract(paymentAmount).compareTo(BigDecimal.ONE) > 0);
        return (balanceAmount.subtract(paymentAmount).compareTo(BigDecimal.ONE) > 0);
    }

    public Card emittedNewCard(BigDecimal initialBalance) {
        System.out.println("Emitted new card with balance [" + initialBalance + "]");
        return Card.builder()
                .cardNumber(getUniqueNumber())
                .expireDate(new Date())
                .balance(initialBalance)
                .initialBalance(initialBalance)
                .build();
    }

    public void activateCard(Card card) {
        System.out.println("Activate card [" + card.getCardNumber() + "]");
        card.setActive(true);
    }

    public void increaseBalance(Card card, BigDecimal increaseAmount) {
        card.setBalance(card.getBalance().add(increaseAmount));
    }

    public void showCardStatistic() {
        System.out.println("Statistic by account:");
        for (Account account : accountStorage.values()) {
            System.out.println("Cards in account [" + account.getAccountNumber() + "]");
            account.getCards().forEach(System.out::println);
        }
    }

}
