package com.learn.thread.exercise3.basic;

import com.learn.thread.exercise3.basic.Processor;

/**
 * Date:    Wednesday, 3/17/21
 * Time:    10:52 AM
 * Author:  Hung.Pham
 */
public class RunExercise {

    public static void main(String[] args) throws InterruptedException {
        Processor processor = new Processor();

        // Creates thread produce.
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Creates thread consume
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start threads
        threadOne.start();
        threadTwo.start();
    }
}
