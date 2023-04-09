package com.eastindia.springcloud.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadDemo {

    public volatile int num = 0;
    Lock lock = new ReentrantLock();
    public /*synchronized*/ void increase() {

        lock.lock();
        num++;//++操作非原子性，分为三个步骤操作
        lock.unlock();
    }

    public static void main(String[] args) {

        MultiThreadDemo demo = new MultiThreadDemo();

        Thread t1 = new Thread(()->{
            for (int j = 0; j < 1000; j++) {
                demo.increase();
            }
        });
        Thread t2 = new Thread(()->{
            for (int j = 0; j < 1000; j++) {
                demo.increase();
            }
        });
        Thread t3 = new Thread(()->{
            for (int j = 0; j < 1000; j++) {
                demo.increase();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        while (Thread.activeCount() > 2) {//保证前面的操作都执行完
            Thread.yield();
        }
        System.out.println("11111111111111:" + demo.num);

    }




}
