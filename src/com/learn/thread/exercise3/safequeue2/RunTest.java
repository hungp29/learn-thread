package com.learn.thread.exercise3.safequeue2;

import java.util.Random;

/**
 * Date:    Friday, 3/19/21
 * Time:    9:49 AM
 * Author:  Hung.Pham
 */
public class RunTest {

    public static void main(String[] args) {
        MyBlockQueue<Integer> blockQueue = new MyBlockQueue<>(10);
        final Runnable producer = () -> {
//            while (true) {
            for (int i = 0; i < 100; i++) {
                Integer ranNum = new Random().nextInt(1000);
                System.out.println("[" + Thread.currentThread().getName() + "] send item: " + ranNum);
                blockQueue.put(ranNum);
            }
        };

//        new Thread(producer).start();
//        new Thread(producer).start();
//        new Thread(producer).start();

        final Runnable consumer = () -> {
            while(true) {
                System.out.println("[" + Thread.currentThread().getName() + "] << process item: " + blockQueue.take());
            }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();


        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
    }
}
