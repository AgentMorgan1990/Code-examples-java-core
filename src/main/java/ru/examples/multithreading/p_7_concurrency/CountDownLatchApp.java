package ru.examples.multithreading.p_7_concurrency;

import java.util.concurrent.CountDownLatch;


/**
 * Пример реализации приложения с использованием CountDownLatch
 *
 * Устанавливаем кол-во щелчков, которое необходимо для продолжения выполнения приложения
 *
 * Так же дополнительно можно выставить таймаут, чтобы запустилось по времени
 *
 * Например, ожидаем, когда на старт гонки подъедут первые 6 машин (хотя их может быть намного больше),
 * а только потом начинаем гонку
 *
 * Щелчки можем делать в разных местах выполнения и несколько раз в одном потоке,
 * в этом большой плюс над обычным join
 */

public class CountDownLatchApp {
    public static void main(String[] args) {
        final int THREADS_COUNT = 6;

        final CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT);

        System.out.println("Начинаем");
        for (int i = 0; i < THREADS_COUNT; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    Thread.sleep(200 * w + (int) (500 * Math.random()));
                    System.out.println("Поток #" + w + " - готов");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Работа завершена");
    }
}
