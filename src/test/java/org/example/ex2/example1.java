package org.example.ex2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

/**
 * пример нормальной синхронизации потоков.
 * 3 потока одновременно изменяют переменную counter. для избежания гонки вводим объект-лок и синхронизируем по нему потоки
 */
@Execution(ExecutionMode.CONCURRENT)
public class example1 {

    private final static Object lock = new Object();

    private static int counter = 0;

    @AfterAll
    static void showUp() {
        System.out.println(counter);
    }

    @Test
    public void t1() throws InterruptedException {

        for (int i = 1; i <= 100; i++) {
            this.add();
        }
        System.out.println("t1 finished.");
    }

    @Test
    public void t2() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            this.add();
        }
        System.out.println("t2 finished.");

    }

    @Test
    public void t3() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            this.add();
        }
        System.out.println("t3 finished.");

    }

    public synchronized void add() throws InterruptedException {
        synchronized (lock) {
            counter++;
            System.out.println(Thread.currentThread().getName() + ": added 1. Sum is: " + counter);
        }
    }
}
