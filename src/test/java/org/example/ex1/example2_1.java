package org.example.ex1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

/**
 * для запуска этого примера нужно создать файл "junit-platform.properties" со строкой "junit.jupiter.execution.parallel.enabled = true" и добавить аннотацию над классом @Execution(ExecutionMode.CONCURRENT)
 * <p>
 * тесты запускаются одновременно, в случайном порядке,
 * все тесты работают с одной переменной value и кэшируют себе её значение. ключевое слово volatile не играет никакой роли
 */
@Execution(ExecutionMode.CONCURRENT)
public class example2_1 {
    private volatile Integer value = 0;

    @Test
    public void t1() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            this.value = this.value + 1;
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": added 1. Sum is: " + this.value);
        }
        System.out.println("t1 finished. " + this.value);
    }

    @Test
    public void t2() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            this.value = this.value + 1;
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": added 1. Sum is: " + this.value);
        }
        System.out.println("t2 finished. " + this.value);

    }

    @Test
    public void t3() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            this.value = this.value + 1;
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": added 1. Sum is: " + this.value);
        }
        System.out.println("t3 finished. " + this.value);

    }

}
