package concurrency.lesson2;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConcurrencyExample {

    public enum SIZE {
        SMALL,
        MEDIUM,
        LARGE
    }

    public List<Integer> storage = getInitializedArrayList(SIZE.SMALL, 1, 500);

    private List<Integer> getInitializedArrayList(SIZE size, int min, int max) {
        switch (size) {
            case SMALL:
                return new Random().ints(500, min, max).boxed().collect(Collectors.toList());
            case MEDIUM:
                return new Random().ints(1000, min, max).boxed().collect(Collectors.toList());
            case LARGE:
                return new Random().ints(10000, min, max).boxed().collect(Collectors.toList());
            default:
                return new Random().ints(100, min, max).boxed().collect(Collectors.toList());
        }
    }

        @Test
        public void deadLockExample () {
        getInitializedArrayList(SIZE.LARGE,100,1000);
            System.out.println("multiple 10");
            storage.stream().filter(i -> i % 10 == 0).forEach(System.out::println);

            System.out.println("multiple 20");
            storage.stream().filter(i -> i % 20 == 0).forEach(System.out::println);
        }

        @Test
        public void executorsExecute () throws InterruptedException {
            ExecutorService executorService = Executors.newCachedThreadPool();

            List<Callable<Long>> tasks = Collections.singletonList(
                    () -> storage.stream().filter(i -> i % 2 == 0).count()
            );

            executorService.invokeAll(tasks).forEach(future -> {
                try {
                    System.out.println(future.get());
                    System.out.println("=======================");
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }

        @Test
        public void whenComparingWithComparator_thenSortedByNameDesc () {
            Storage[] storages = new Storage[0];
            Comparator<Storage> employeeNameComparator
                    = Comparator.comparing(
                    Storage::getModel, Comparator.reverseOrder());

            Arrays.sort(storages, employeeNameComparator);

            assertTrue(Arrays.equals(storages, storages));
        }


        @Test
        public void runnableExecute () {
            for (int i = 0; i < 100; i++) {
                Thread thread = new Thread(getRunnable());
                thread.start();
            }
        }

        public Runnable getRunnable () {
            return () -> {
                System.out.println(Thread.currentThread().getName());
            };
        }
    }
