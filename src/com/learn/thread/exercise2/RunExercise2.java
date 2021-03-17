package com.learn.thread.exercise2;

/**
 * Date:    Tuesday, 3/16/21
 * Time:    11:24 AM
 * Author:  Hung.Pham
 */
public class RunExercise2 {

    public static void main(String[] args) throws InterruptedException {
        ThreadOne threadOne = new ThreadOne(2);
        ThreadTwo threadTwo = new ThreadTwo(2);

        // Start thread One
        threadOne.start();

        // Thread main wait for thread One to die
        threadOne.join();

        // Thread Two start after thread One has died
        threadTwo.start();
    }
}
