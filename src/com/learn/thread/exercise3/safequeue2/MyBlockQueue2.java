package com.learn.thread.exercise3.safequeue2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date:    Friday, 3/19/21
 * Time:    10:33 AM
 * Author:  Hung.Pham
 */
public class MyBlockQueue2<E> {

    private Queue<E> queue = new LinkedList<>();
    private int maxSize = 10;

    public MyBlockQueue2(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void put(E item) {
        while (queue.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(item);
        System.out.println("[" + Thread.currentThread().getName() + "] items: " + queue.toString());
        if (queue.size() == 1) {
            notifyAll();
        }
    }

    public synchronized E take() {
        while (queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        E item = queue.remove();
        System.out.println("[" + Thread.currentThread().getName() + "] << take item: " + item);
        if (queue.size() < maxSize) {
            notifyAll();
        }
        return item;
    }
}
