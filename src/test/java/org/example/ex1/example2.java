package org.example.ex1;

import org.junit.jupiter.api.Test;

public class example2 {

    /**
     * для запуска в консоли: mvn clean test
     * <p>
     * для запуска в ide, в Run Configurations передать параметры:
     * -Djunit.jupiter.execution.parallel.enabled=true
     * -Djunit.jupiter.execution.parallel.mode.default=concurrent
     * <p>
     * * файл .properties для этого примера не нужен
     * тесты запускаются одновременно, в случайном порядке,
     * все тесты работают с одной переменной value и кэшируют себе её значение. ключевое слово volatile не играет никакой роли
     */
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
