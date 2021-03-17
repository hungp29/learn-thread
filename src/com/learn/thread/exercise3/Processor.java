package com.learn.thread.exercise3;

import java.util.Random;
import java.util.Scanner;

/**
 * Date:    Wednesday, 3/17/21
 * Time:    10:50 AM
 * Author:  Hung.Pham
 */
public class Processor {

    private String value;

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread is running...");
            wait();
            System.out.println("The value user enter: " + value);
        }
    }

    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        synchronized (this) {
            System.out.println("Consumer thread is running ...");
            System.out.print("Please enter value: ");
            value = scanner.next();
            notify();
        }
    }
}
