package ru.examples.multithreading.p_7_concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * Пример приложения с использованием CyclicBarrier
 *
 * Можем устанавливать счётчик несколько раз на разных этапах в отличие от CountDownLatch
 * Когда счётчик сбрасывается, продолжаем выполнение процесса и можем выставить ещё раз.
 *
 * Можно применять там, где необходимо завершать один этап перед переходом на второй,
 * а потом завершить второй для перехода на третий и т.д.
 *
 * Так же можно устанавливать таймаут
 *
 */
public class CyclicBarrierApp {
    public static void main(String[] args) {
        final int THREADS_COUNT = 5;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREADS_COUNT);
        for (int i = 0; i < THREADS_COUNT; i++) {
            int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Подготавливается " + w);
                    Thread.sleep(2000 + 500 * (int) (Math.random() * 10));
                    System.out.println("Готов " + w);
                    System.out.println("Кол-во ожидающих: " + cyclicBarrier.getNumberWaiting());
                    System.out.println("Необходимое кол-во для старта " + cyclicBarrier.getParties());
                    cyclicBarrier.await(); // 4 3 2 1 0
                    System.out.println("Поехал " + w);
                    Thread.sleep(2000 + 500 * (int) (Math.random() * 10));
                    System.out.println("Доехал " + w);
                    cyclicBarrier.await(); // 4 3 2 1 0
                    System.out.println("Гонка закончилась");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
