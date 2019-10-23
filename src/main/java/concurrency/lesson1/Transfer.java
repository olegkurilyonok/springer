package concurrency.lesson1;

import java.math.BigDecimal;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Transfer implements Callable<Boolean> {
    final CustomerAccount customerAccount1;
    final CustomerAccount customerAccount2;
    final BigDecimal amount;

    public Transfer(CustomerAccount customerAccount1, CustomerAccount customerAccount2, BigDecimal amount) {
        this.customerAccount1 = customerAccount1;
        this.customerAccount2 = customerAccount2;
        this.amount = amount;
    }

    public Boolean call() {
        System.out.println("Current thread name:" + Thread.currentThread().getName());
        return transfer(customerAccount1, customerAccount2, amount);
    }

    private static boolean transfer(CustomerAccount acc1,
                                    CustomerAccount acc2,
                                    BigDecimal amount) {
        Lock lock = new ReentrantLock();
        lock.lock();
        if (acc1.getBalance().compareTo(amount) < 0){
            System.out.println("Balance is empty!");
            return false;
        }
        acc1.decreaseBalance(amount);
        acc2.increaseBalance(amount);
        System.out.println("==============================");
        System.out.println("acc1 account balance:"+acc1.getBalance());
        System.out.println("acc2 account balance:"+acc2.getBalance());
        lock.unlock();
        return true;
    }

}
