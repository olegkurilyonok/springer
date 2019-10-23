package concurrency.lesson1;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ConcurrencyExecutorsExample{

    @Test
    public void concurrencyExecute() {

        ArrayList<Integer> li = new ArrayList<Integer>();
        ArrayList<Float> lf = new ArrayList<Float>();
        if (li.getClass() == lf.getClass()) // evaluates to true
            System.out.println("Equal");
//        CustomerAccount customerAccount1 = new CustomerAccount(new BigDecimal(5000));
//        CustomerAccount customerAccount2 = new CustomerAccount(new BigDecimal(1000));
//
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            executor.submit( new Transfer(customerAccount1,customerAccount2,new BigDecimal(250)));
//        }
    }
}
