package com.learn.thread.exercise3.safequeue;

/**
 * Date:    Thursday, 3/18/21
 * Time:    1:14 AM
 * Author:  Hung.Pham
 */
public class RunTest {

    public static void main(String[] args) {
        ThreadSafeQueue threadSafeQueue = new ThreadSafeQueue();

        (new Thread("Receiver") {
            @Override
            public void run() {
                try {
                    System.out.println("Value get from queue: " + threadSafeQueue.poll());
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
                    threadSafeQueue.push("Hello from Hue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
