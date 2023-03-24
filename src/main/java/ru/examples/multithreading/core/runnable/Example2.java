package ru.examples.multithreading.core.runnable;

public class Example2 {
}


class MyThread implements Runnable {

    float[] arr;
    int startPosition;

    public MyThread(float[] arr, int startPosition) {
        this.arr = arr;
        this.startPosition = startPosition;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] = startPosition);
            startPosition++;
        }
    }
}


class TestRunnable {

    public static void main(String[] args) {
        float[] arr = {1.3f, 1.78f, 67.67f};
        Thread t = new Thread(new MyThread(arr, 15));
        t.start();
    }
}
