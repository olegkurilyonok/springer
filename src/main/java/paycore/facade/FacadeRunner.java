package paycore.facade;

import org.junit.jupiter.api.Test;
import paycore.facade.utils.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FacadeRunner {
    private ProcessingCenter processingCenter = ProcessingCenter.getInstance();
    public static final Integer TEST_PAYMENTS_NUMBER = 30000;
    public static final Integer TEST_PAYMENTS_RANGE_MIN = 10;
    public static final Integer TEST_PAYMENTS_RANGE_MAX = 220;

    public static final Integer TEST_CARD_COUNT = 10;
    public static final Integer TEST_CARDS_BALANCE_RANGE_MIN = TEST_PAYMENTS_NUMBER*TEST_PAYMENTS_RANGE_MIN/10;
    public static final Integer TEST_CARDS_BALANCE_RANGE_MAX = TEST_PAYMENTS_NUMBER*TEST_PAYMENTS_RANGE_MAX/10;


    @Test
    public void runFacadePattern() {
        TransferServiceFacade transferService = new TransferServiceFacade();

        Account account = processingCenter.createAccount();
        createCards(account);

        createPaymentList().forEach(payment -> {
            System.out.println("========= Start transfer =========");
            transferService.transfer(account, account.getCards().get(0), payment);
        });

        transferService.showHistory();
        transferService.showStatistic();
        transferService.showCardStatistic();
    }

    private void createCards(Account account) {
        for (int i = 0; i < TEST_CARD_COUNT; i++) {
            Card card = processingCenter.emittedNewCard(new BigDecimal(getRandomNumberInRange(TEST_CARDS_BALANCE_RANGE_MIN, TEST_CARDS_BALANCE_RANGE_MAX)));
            card.setAllowedForPayment(true);
            account.getCards().add(card);
        }
    }

    private List<BigDecimal> createPaymentList() {
        List<BigDecimal> payments = new ArrayList<>();
        for (int i = 0; i < TEST_PAYMENTS_NUMBER; i++) {
            payments.add(new BigDecimal(getRandomNumberInRange(TEST_PAYMENTS_RANGE_MIN, TEST_PAYMENTS_RANGE_MAX)));
        }
        return payments;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
