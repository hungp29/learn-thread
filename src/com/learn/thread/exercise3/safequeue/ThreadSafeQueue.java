package com.learn.thread.exercise3.safequeue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date:    Thursday, 3/18/21
 * Time:    1:10 AM
 * Author:  Hung.Pham
 */
public class ThreadSafeQueue {

    private final Queue<String> queue = new LinkedList<>();
    private static final Object MUTEX = new Object();

    public void push(String value) throws InterruptedException {
        synchronized (MUTEX) {
            queue.add(value);
            MUTEX.notify();
            System.out.println("[" + Thread.currentThread().getName() + "] Release MUTEX ...");
        }
    }

    public String poll() throws InterruptedException {
        synchronized (MUTEX) {
            while (queue.isEmpty()) {
                System.out.println("[" + Thread.currentThread().getName() + "] Release MUTEX ...");
                MUTEX.wait();
            }
        }
        return queue.poll();
    }
}
