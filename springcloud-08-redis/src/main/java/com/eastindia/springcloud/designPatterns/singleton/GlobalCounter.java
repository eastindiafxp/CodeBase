package com.eastindia.springcloud.designPatterns.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举本身就是单例
 * 实现一个全局计数器
 * 枚举天然杜绝有人使用反射创建实例
 */
public enum GlobalCounter {

    INSTANCE;
    private AtomicLong atomicLong = new AtomicLong(0);

    public long getNum() {
        return atomicLong.getAndIncrement();
    }


}
