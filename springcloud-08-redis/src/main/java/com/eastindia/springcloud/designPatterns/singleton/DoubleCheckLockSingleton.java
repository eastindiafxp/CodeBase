package com.eastindia.springcloud.designPatterns.singleton;

/**
 * 双重检查锁单例的实现
 */
public class DoubleCheckLockSingleton {


    //    1、持有一个jvm全局唯一的实例
//    直接在定义的时候将其new出来，这是饿汉式；在调用的时候再创建，这叫懒汉式
//    创建对象不是一个原子性的操作，及时使用了双重检查锁，也可能在创建的过程中产生半初始化状态（使用volatile关键字）
    private static volatile DoubleCheckLockSingleton instance;
//    volatile  保证内存可见；保证有序性（jdk1.9以上，不加volatile也可以，jvm内部处理有序性）

    //    2、为了避免别人恶意创建，我们要私有化构造器
    private DoubleCheckLockSingleton() {

//        升级版本——>不要让人使用反射创建实例
        if (instance != null) {
            throw new RuntimeException("该对象是单例的，无法创建多个！");
        }
    }

    //    3、暴露一个方法，用来获取实例
//    第一次创建需要上锁，一旦创建好了就不需要锁
//    获取单例并没有线程安全问题
    public static DoubleCheckLockSingleton getInstance() {

        if (null == instance) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckLockSingleton();
                }
            }

        }
        return instance;
    }

    //返序列化创建实例时，避免创建新实例
    public Object readResolve() {
        return instance;
    }


}
