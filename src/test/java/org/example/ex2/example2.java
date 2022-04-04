package org.example.ex2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.ArrayList;
import java.util.List;

/**
 * пример синхронизации при работе с коллекцией.
 * 3 потока складывают в одну коллекцию значения.
 */
@Execution(ExecutionMode.CONCURRENT)
public class example2 {

    private static final List<Integer> list = new ArrayList<>();

    @Test
    public void t1() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            addToList(0);
        }
    }

    @Test
    public void t2() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            addToList(1);
        }
    }

    @Test
    public void t3() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            addToList(2);
        }
    }

    public static void addToList(int value) throws InterruptedException {
        synchronized (list) {// получить монитор объекта
            list.add(value);// произвести действие
            Thread.sleep(50); // спим, просто для наглядности
            System.out.println(Thread.currentThread().getName() + " added value: " + value); // сообщаем о действии
        } // освобождаем монитор
    }

    @AfterAll
    public static void result() {
        int zero = (int) list.stream().filter(item -> item == 0).count();
        int one = (int) list.stream().filter(item -> item == 1).count();
        int two = (int) list.stream().filter(item -> item == 2).count();
        System.out.println("zero: " + zero);
        System.out.println("one: " + one);
        System.out.println("two: " + two);
    }
}
