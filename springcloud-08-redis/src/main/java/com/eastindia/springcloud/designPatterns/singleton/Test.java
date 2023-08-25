package com.eastindia.springcloud.designPatterns.singleton;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class Test {

    public static void main(String[] args) {

//        System.out.println("饿汉式:" + (EargerSingleton.getInstance() == EargerSingleton.getInstance()));
//        System.out.println("懒汉式:" + (LazySingleton.getInstance() == LazySingleton.getInstance()));
//        System.out.println("双重检查式:" + (DoubleCheckLockSingleton.getInstance() == DoubleCheckLockSingleton.getInstance()));
//
//        GlobalCounter.INSTANCE.getNum();
//        GlobalCounter.INSTANCE.getNum();
//        Long a = GlobalCounter.INSTANCE.getNum();
//        System.out.println(a);
//        log.info("23");

        try {
            testReflect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

//    通过反射破坏单例
    public static void testReflect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<DoubleCheckLockSingleton> clazz = DoubleCheckLockSingleton.class;
        Constructor<DoubleCheckLockSingleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        boolean flag = DoubleCheckLockSingleton.getInstance() == constructor.newInstance();
        System.out.println(flag);

    }


}
