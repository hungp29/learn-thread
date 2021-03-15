package com.learn.thread.exercise1;

/**
 * Call and run threads.
 * Date:    Saturday, 3/13/21
 * Time:    10:44 AM
 * Author:  Hung.Pham
 */
public class RunExercise {
    public static void main(String[] args) {
        System.out.println("Start Main");

        // Thread One
        ThreadOne threadOne = new ThreadOne();
        threadOne.start();

        // Thread Two
        ThreadTwoRunnable threadTwoRunnable = new ThreadTwoRunnable();
        Thread threadTwo = new Thread(threadTwoRunnable);
        threadTwo.start();

        System.out.println("End Main");
    }
}
