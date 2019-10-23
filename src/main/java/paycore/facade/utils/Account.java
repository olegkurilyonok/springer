package paycore.facade.utils;

import paycore.facade.Card;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String ownerId;
    private String accountNumber;
    private List<Card> cards;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Card> getCards() {
        if (cards == null)
            cards = new ArrayList<>();
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Account(String ownerId, String accountNumber) {
        this.ownerId = ownerId;
        this.accountNumber = accountNumber;
    }
}
