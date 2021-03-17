package com.learn.thread.exercise2;

/**
 * Date:    Tuesday, 3/16/21
 * Time:    10:14 AM
 * Author:  Hung.Pham
 */
public class RunExercise {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Start");
        ThreadOne threadOne = new ThreadOne(10);
        ThreadTwo threadTwo = new ThreadTwo(10);

        // Start thread One and Two
        threadOne.start();
        threadTwo.start();

        // Thread main will wait for thread One to die
        threadOne.join();

        System.out.println("Main End");
    }
}
