package com.eastindia.springcloud.designPatterns.singleton;

/**
 * 饿汉式单例的实现
 */
public class EargerSingleton {

    /**
     * 1、创建对象本身的复杂度
     * 很多的单例对象创建的过程可能及其复杂
     * 很多单例对象创建完成后会占用很大内存，比如缓存对象
     * 很多单例对象创建完成后可能很小且很简单
     *
     */

//    1、持有一个jvm全局唯一的实例，线程安全
//    直接在定义的时候将其new出来，这就叫饿汉式
    private final static EargerSingleton instance = new EargerSingleton();

//    2、为了避免别人恶意创建，我们要私有化构造器
    private EargerSingleton(){}

//    3、暴露一个方法，用来获取实例
    public static EargerSingleton getInstance() {
        return instance;
    }


}
