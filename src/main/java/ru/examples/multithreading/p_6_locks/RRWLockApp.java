package ru.examples.multithreading.p_6_locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 *
 * Пример работы класса ReentrantReadWriteLock
 * Даёт возможность одновременно читать нескольким читателям, но писать может только один писатель.
 * Автоматически регулирует очередь из читателей и из писателей, чтобы не было большого простоя у писателей.
 *
 * Не может быть такого, что во время чтения кто-то будет писать, а во время записи будет больше одного писателя.
 *
 */

public class RRWLockApp {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

        new Thread(() -> {
            try {
                rwl.readLock().lock();
                System.out.println("READING-start-a");
                Thread.sleep(3000);
                System.out.println("READING-end-a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rwl.readLock().lock();
                System.out.println("READING-start-b");
                Thread.sleep(5000);
                System.out.println("READING-end-b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                rwl.readLock().lock();
                System.out.println("READING-start-c");
                Thread.sleep(3000);
                System.out.println("READING-end-c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                rwl.readLock().lock();
                System.out.println("READING-start-d");
                Thread.sleep(3000);
                System.out.println("READING-end-d");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rwl.writeLock().lock();
                System.out.println("WRITING-start-a");
                Thread.sleep(3000);
                System.out.println("WRITING-end-a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.writeLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rwl.writeLock().lock();
                System.out.println("WRITING-start-b");
                Thread.sleep(3000);
                System.out.println("WRITING-end-b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.writeLock().unlock();
            }
        }).start();
    }


}
