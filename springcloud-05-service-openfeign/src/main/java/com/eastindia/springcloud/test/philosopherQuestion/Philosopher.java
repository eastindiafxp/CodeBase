package com.eastindia.springcloud.test.philosopherQuestion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Philosopher extends Thread {

    private ChopStick left;
    private ChopStick right;
    private int index;

    public Philosopher(String name, int index, ChopStick left, ChopStick right) {

        this.setName(name);
        this.index = index;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {

//        if (index == 0) {//或者index是奇数的取左侧筷子，偶数的取右侧筷子，这样并发吃饭，效率更高
        if (index % 2 == 0) {
            synchronized (left) {
                try {
                    Thread.sleep(1000 + index * 1000);

                    synchronized (right) {
                        Thread.sleep(1000);
                        System.out.println(index + "号哲学家" + getName() + "已经吃完！");
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            synchronized (right) {
                try {
                    Thread.sleep(1000 + index * 1000);

                    synchronized (left) {
                        Thread.sleep(1000);
                        System.out.println(index + "号哲学家" + getName() + "已经吃完！");
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    /**
     * 哲学家就餐问题
     * @param args
     */
    public static void main(String[] args) {

        ChopStick chopStick0 = new ChopStick();
        ChopStick chopStick1 = new ChopStick();
        ChopStick chopStick2 = new ChopStick();
        ChopStick chopStick3 = new ChopStick();
        ChopStick chopStick4 = new ChopStick();

        Philosopher philosopher0 = new Philosopher("苏格拉底", 0, chopStick0, chopStick1);
        Philosopher philosopher1 = new Philosopher("柏拉图", 1, chopStick1, chopStick2);
        Philosopher philosopher2 = new Philosopher("亚里士多德", 2, chopStick2, chopStick3);
        Philosopher philosopher3 = new Philosopher("荷马", 3, chopStick3, chopStick4);
        Philosopher philosopher4 = new Philosopher("欧几里得", 4, chopStick4, chopStick0);

        philosopher0.start();
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();


    }

}
