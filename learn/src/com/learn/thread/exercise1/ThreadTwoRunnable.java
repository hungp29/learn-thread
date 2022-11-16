package com.learn.thread.exercise1;

/**
 * Creates new Thread by implement Runnable interface.
 * Date:    Saturday, 3/13/21
 * Time:    10:47 AM
 * Author:  Hung.Pham
 */
public class ThreadTwoRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread Two " + i);
        }
    }
}
