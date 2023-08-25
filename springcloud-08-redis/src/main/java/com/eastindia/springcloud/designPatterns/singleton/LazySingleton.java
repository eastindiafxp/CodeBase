package com.eastindia.springcloud.designPatterns.singleton;

/**
 * 懒汉式单例的实现
 */
public class LazySingleton {


    //    1、持有一个jvm全局唯一的实例
//    直接在定义的时候将其new出来，这是饿汉式；在调用的时候再创建，这叫懒汉式
    private static LazySingleton instance;

    //    2、为了避免别人恶意创建，我们要私有化构造器
    private LazySingleton(){}

    //    3、暴露一个方法，用来获取实例
    public synchronized static LazySingleton getInstance() {

        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }


}
