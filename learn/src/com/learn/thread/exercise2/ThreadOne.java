package com.learn.thread.exercise2;

/**
 * Date:    Tuesday, 3/16/21
 * Time:    10:12 AM
 * Author:  Hung.Pham
 */
public class ThreadOne extends Thread {

    private int num;

    public ThreadOne(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Value: " + i);
        }
    }
}
