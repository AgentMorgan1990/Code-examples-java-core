package ru.examples.multithreading.p_7_concurrency;

import java.util.concurrent.ArrayBlockingQueue;



/**
 * Пример использования ArrayBlockingQueue
 * Если очередь переполнена, уведомляет производителя, что потребитель что-то из неё забрал и можно положить
 * Если очередь пустая, уведомляет потребителя, что производитель что-то положил и можно забирать
 *
 * Есть несколько методов, для того чтобы что-то положить в очередь:
 *
 * .add() - вставляет указанный элемент в конец этой очереди, если это возможно сделать немедленно,
 * не превышая вместимость очереди, возвращая значение true при успешном выполнении
 * и вызывая исключение IllegalStateException, если эта очередь заполнена.
 *
 * .put() - вставляет указанный элемент в конец этой очереди, ожидая, пока освободится место, если очередь заполнена.
 *
 * .offer() - Вставляет указанный элемент в конец этой очереди, если это возможно сделать немедленно,
 * не превышая вместимость очереди, возвращая true при успешном выполнении и false, если эта очередь заполнена.
 *
 * .offer(long timeout, TimeUnit unit) - Извлекает и удаляет начало этой очереди, ожидая до указанного времени ожидания,
 * если необходимо, чтобы элемент стал доступным.
 *
 * Есть несколько методов, чтобы что-то забрать из очереди:
 *
 * .take() - извлекает и удаляет начало этой очереди, ожидая, если необходимо, пока элемент не станет доступным.
 *
 * .peek() - извлекает, но не удаляет, заголовок этой очереди или возвращает значение null, если эта очередь пуста.
 *
 * .poll() - извлекает и удаляет заголовок этой очереди или возвращает значение null, если эта очередь пуста.
 *
 * .poll(long timeout, TimeUnit unit) извлекает и удаляет начало этой очереди, ожидая до указанного времени ожидания,
 * если необходимо, чтобы элемент стал доступным.
 *
 *
 * */
public class ArrayBlockingQueueApp {
    static class Producer {
        private ArrayBlockingQueue<String> queue;

        public Producer(ArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        public void put(String x) {
            try {
                System.out.println("Producer add: " + x);
                queue.put(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer {
        private ArrayBlockingQueue<String> queue;

        public Consumer(ArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        public String get() {
            try {
                String str = queue.take();
                System.out.println("Consumer get: " + str);
                return str;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        final ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(4);
        new Thread(() -> {
            Producer p = new Producer(arrayBlockingQueue);
            for (int i = 0; i < 10; i++) {
                try {
                    p.put(String.valueOf(i));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            Consumer c = new Consumer(arrayBlockingQueue);
            for (int i = 0; i < 10; i++) {
                try {
                    c.get();
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
