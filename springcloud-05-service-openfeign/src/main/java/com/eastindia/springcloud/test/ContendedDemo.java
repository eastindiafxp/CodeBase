package com.eastindia.springcloud.test;

public class ContendedDemo {

//    @Contended

//    @sun.misc.Contended
    public volatile long x;
//    public long p1, p2, p3, p4, p5, p6, p7;
    public volatile long y;

    public static void main(String[] args) {

        ContendedDemo demo = new ContendedDemo();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000000000l; i++) {
                demo.x = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000000000l; i++) {
                demo.y = i;
            }
        });

        long start = System.currentTimeMillis();

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.print("耗时：");
        System.out.println(end - start);

    }


}
