package ru.examples.multithreading.p_5_executor_service;

import java.util.concurrent.*;


/**
 *
 * Executors.newSingleThreadExecutor() - создаёт один поток
 *
 * Executors.newCachedThreadPool() - создаёт необходимое кол-во потоков,
 * при росте нагрузки кол-во потоков автоматически увеличивается,
 * при снижении нагрузки кол-во потоков уменьшается
 *
 * executorService.shutdown() - завершает работу всех потоков, после того, как они обработают все задачи
 *
 * executorService.awaitTermination(10, TimeUnit.MINUTES) - выполняет дальнейшие операции после завершения
 * работы всех потоков
 *
 * */

public class CashedThreadPoolExecutorServiceExampleApp {

    public static void main(String[] args) throws InterruptedException {
        startFirstExample();
    }

    private static void startFirstExample() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println("Start Task");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task ended");
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("All task ended");
    }

}
