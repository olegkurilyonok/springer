package paycore.facade.exceptions;

import lombok.Data;

@Data
public class NotEnoughMoney extends Exception {
    private String transactionId;
}
