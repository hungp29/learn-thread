package com.learn.thread.exercise3.safequeue2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date:    Friday, 3/19/21
 * Time:    9:34 AM
 * Author:  Hung.Pham
 */
public class MyBlockQueue<E> {

    private Queue<E> queue;
    private int maxSize = 10;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public MyBlockQueue(int maxSize) {
        queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void put(E item) {
        lock.lock();
        try {
            if (queue.size() == maxSize) {
                notFull.await();
            }
//            System.out.println("[" + Thread.currentThread().getName() + "] put item: " + item);
            queue.add(item);
            System.out.println("[" + Thread.currentThread().getName() + "] items: " + queue.toString());
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            E item = queue.remove();
            System.out.println("[" + Thread.currentThread().getName() + "] << take item: " + item);
            notFull.signalAll();
            return item;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }
}
