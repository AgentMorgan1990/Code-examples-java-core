package ru.examples.multithreading.p_5_executor_service;

import java.util.concurrent.*;



/**
 *
 * Executors.newFixedThreadPool(4) - создаёт определённое кол-во потоков
 * создаёт новые потоки по мере, получения новых задач до достижения указанного кол-ва потоков.
 * Например, создаёт второй поток, даже если завершил работу первый -> startSecondExample()
 *
 * CompletableFuture - более продвинутый вариант
 *
 * */
public class FixedThreadPoolExecutorServiceExampleApp {

    public static void main(String[] args) throws Exception {
        startFirstExample();
        startSecondExample();
    }

    private static void startFirstExample() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "Java";
            }
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("END");
        service.shutdown();
    }

    private static void startSecondExample() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setPriority(10);
                t.setName("ABC");
                System.out.println("created");
                return t;
            }
        });

        service.execute(() -> System.out.println(1));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(2));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(3));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(4));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(5));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(6));
        Thread.sleep(2000);
        service.shutdown();
    }
}
