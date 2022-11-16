package com.learn.thread.exercise2;

/**
 * Date:    Tuesday, 3/16/21
 * Time:    3:34 PM
 * Author:  Hung.Pham
 */
public class RunExercise3 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Start");
        ThreadOne threadOne = new ThreadOne(5);
        ThreadTwo threadTwo = new ThreadTwo(5);

        // Start thread One and Two
        threadOne.start();
        threadTwo.start();

        // Thread main will wait for thread One to die in 4000 millis
        threadOne.join(4000);

        System.out.println("Main End");
    }
}
