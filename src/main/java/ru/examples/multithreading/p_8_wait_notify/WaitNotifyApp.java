package ru.examples.multithreading.p_8_wait_notify;




/**
 * Пример использования методов wait и notifyAll
 *
 * синхронизируем методы по монитору
 *
 * Поток проверяет какую букву сейчас надо печатать, если не его, переходит в режим ожидания
 *
 * while (currentLetter != 'A') {
 *                         mon.wait();
 *                     }
 *
 * если его очередь печатает букву и оповещает остальные потоки,
 * чтобы вышли из ожидания и проверили их ли очередь печатать букву
 *
 *   System.out.print("A");
 *   currentLetter = 'B';
 *   mon.notifyAll();
 *
 *
 * */
public class WaitNotifyApp {
    private final Object mon = new Object();
    private char currentLetter = 'A';

    public static void main(String[] args) {
        WaitNotifyApp waitNotifyApp = new WaitNotifyApp();
        new Thread(() -> {
            waitNotifyApp.printA();
        }).start();
        new Thread(() -> {
            waitNotifyApp.printB();
        }).start();
        new Thread(() -> {
            waitNotifyApp.printC();
        }).start();
    }

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        mon.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    mon.notifyAll();
                    Thread.sleep(2500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    mon.notifyAll();
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        mon.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    mon.notifyAll();
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
