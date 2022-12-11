package ru.examples.multithreading.p_5_executor_service;


/**
 * Для корректной остановки потока необходимо применять метод .interrupt()
 * для этого необходимо продумать возможные места остановки при выполнении в потоке,
 * например ->
 *                 if (Thread.currentThread().isInterrupted()) {
 *                     break;
 *                 }
 *
 * Дополнительно при засыпании потока необходимо обрабатывать InterruptedException, т.к. спящий поток не может
 * выполнить метод .interrupt()
 *
 * Например, вводим переменную boolean inter = false и если ловим исключение InterruptedException поднимаем флаг в true
 *
 * InterruptedException возникает именно тогда когда поток спит, а мы пытаемся вызвать метод .interrupt()
 *
 *
 * */
public class InterruptionExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            boolean inter = false;
            while (true) {
                if (Thread.currentThread().isInterrupted() || inter) {
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    inter = true;
                }
                System.out.println(1);
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
