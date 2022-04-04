package org.example.ex1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * для запуска этого примера нужно создать файл "junit-platform.properties" со строкой "junit.jupiter.execution.parallel.enabled = true" и добавить аннотацию над классом @Execution(ExecutionMode.CONCURRENT)
 * <p>
 * тесты запускаются одновременно, в случайном порядке,
 * все тесты работают с одной переменной value и кэшируют себе её значение. ключевое слово volatile не играет никакой роли
 */
@Execution(ExecutionMode.CONCURRENT)
public class example1_1 {
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
