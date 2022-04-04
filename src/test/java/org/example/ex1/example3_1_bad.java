package org.example.ex1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

/**
 * типичный пример плохой работы с многопоточкой:
 * несколько потоков пытаются одновременно положить в counter новое значение. в результате число будет не 300, а каждый раз новое
 * <p>
 * для запуска этого примера нужно создать файл "junit-platform.properties" со строкой "junit.jupiter.execution.parallel.enabled = true" и добавить аннотацию над классом @Execution(ExecutionMode.CONCURRENT)
 * <p>
 * тесты запускаются одновременно, в случайном порядке,
 * все тесты работают с одной переменной value и кэшируют себе её значение. ключевое слово volatile не играет никакой роли
 */

@Execution(ExecutionMode.CONCURRENT)
@ResourceLock(value = "counter", mode = ResourceAccessMode.READ)
public class example3_1_bad {

    private static Integer counter = 0;

    @Test
    public void t1() throws InterruptedException {

        for (int i = 0; i <= 100; i++) {
            counter = counter + 1;
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": added 1. Sum is: " + counter);
        }
        System.out.println("t1 finished. " + counter);
    }

    @Test
    public void t2() throws InterruptedException {
        for (int i = 0; i <= 100; i++) {
            counter = counter + 1;
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": added 1. Sum is: " + counter);
        }
        System.out.println("t2 finished. " + counter);

    }

    @Test
    public void t3() throws InterruptedException {
        for (int i = 0; i <= 100; i++) {
            counter = counter + 1;
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": added 1. Sum is: " + counter);
        }
        System.out.println("t3 finished. " + counter);

    }
}
