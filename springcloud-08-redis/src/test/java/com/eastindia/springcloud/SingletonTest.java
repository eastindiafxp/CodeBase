package com.eastindia.springcloud;

import com.eastindia.springcloud.designPatterns.singleton.DoubleCheckLockSingleton;
import com.eastindia.springcloud.designPatterns.singleton.EargerSingleton;
import com.eastindia.springcloud.designPatterns.singleton.LazySingleton;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SingletonTest {

    @Test
    public void testSingleton() {

        System.out.println("饿汉式:" + (EargerSingleton.getInstance() == EargerSingleton.getInstance()));
        System.out.println("懒汉式:" + (LazySingleton.getInstance() == LazySingleton.getInstance()));
        System.out.println("双重检查式:" + (DoubleCheckLockSingleton.getInstance() == DoubleCheckLockSingleton.getInstance()));

    }

}
