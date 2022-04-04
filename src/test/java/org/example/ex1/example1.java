package org.example.ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * для запуска в консоли: mvn clean test
 * <p>
 * для запуска в ide, в Run Configurations передать параметры:
 * -Djunit.jupiter.execution.parallel.enabled=true
 * -Djunit.jupiter.execution.parallel.mode.default=concurrent
 * <p>
 * файл .properties для этого примера не нужен
 * тесты запускаются одновременно, в случайном порядке, нет причин для взаимной блокировки/нет общих блоков
 */
public class example1 {
    @Test
    public void t1() throws InterruptedException {
        System.out.println("t1 started");
        int sum = 0;
        int expect = 100;
        for (int i = 0; i < expect; i++) {
            sum++;
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": added 1. Sum is: " + sum);
        }
        assertEquals(expect, sum);
        System.out.println("t1 finished");
    }

    @Test
    public void t2() throws InterruptedException {
        System.out.println("t2 started");
        int sum = 0;
        int expect = 100;
        for (int i = 0; i < expect; i++) {
            sum++;
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": added 1. Sum is: " + sum);

        }
        assertEquals(expect, sum);
        System.out.println("t2 finished");

    }

    @Test
    public void t3() throws InterruptedException {
        System.out.println("t3 started");
        int sum = 0;
        int expect = 100;
        for (int i = 0; i < expect; i++) {
            sum++;
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": added 1. Sum is: " + sum);

        }
        assertEquals(expect, sum);
        System.out.println("t3 finished");

    }
}
