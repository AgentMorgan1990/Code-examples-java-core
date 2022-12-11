package ru.examples.multithreading.p_7_concurrency;

import java.util.concurrent.Semaphore;


/**
 * Пример реализации Semaphore
 * Устанавливает кол-во потоков, которые могут одновременно использовать ресурс
 * <p>
 * Применяется в тех частях кода, где производительность сначала растёт с увеличением кол-ва потоков, а потом падает
 * Например запись на диск и т.п.
 */

public class SemaphoreSimpleApp {
    public static void main(String[] args) {
        final Semaphore smp = new Semaphore(4);

        Runnable limitedCall = new Runnable() {
            int count = 0;

            public void run() {
                int time = 3 + (int) (Math.random() * 4.0);
                int num = count++;
                try {
                    smp.acquire();
                    System.out.println("Поток #" + num + " начинает выполнять очень долгое действие " + time + " сек.");
                    Thread.sleep(time * 1000);
                    System.out.println("Поток #" + num + " завершил работу!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    smp.release();
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(limitedCall).start();
        }
    }
}
