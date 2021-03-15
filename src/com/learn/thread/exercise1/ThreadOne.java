package com.learn.thread.exercise1;

/**
 * Creates new Thread by extend Thread class.
 * Date:    Saturday, 3/13/21
 * Time:    10:44 AM
 * Author:  Hung.Pham
 */
public class ThreadOne extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread One " + i);
        }
    }
}
