package com.learn.thread.exercise3.safequeue;

import java.util.Arrays;

/**
 * Date:    Thursday, 3/18/21
 * Time:    1:14 AM
 * Author:  Hung.Pham
 */
public class RunTest2 {

    public static void main(String[] args) {
        ThreadSafeQueue2 threadSafeQueue = new ThreadSafeQueue2();

        (new Thread("Receiver 1") {
            @Override
            public void run() {
                try {
                    System.out.println("[" + Thread.currentThread().getName() + "] Value get from queue: " + threadSafeQueue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        (new Thread("Receiver 2") {
            @Override
            public void run() {
                try {
                    System.out.println("[" + Thread.currentThread().getName() + "] Value get from queue: " + threadSafeQueue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        (new Thread("Sender") {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    threadSafeQueue.push(Arrays.asList("Hello from Hue", "Welcome to Hue"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
