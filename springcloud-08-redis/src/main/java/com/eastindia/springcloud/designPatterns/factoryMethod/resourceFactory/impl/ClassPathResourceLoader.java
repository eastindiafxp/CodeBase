package com.eastindia.springcloud.designPatterns.factoryMethod.resourceFactory.impl;

import com.eastindia.springcloud.designPatterns.factoryMethod.resourceFactory.IResourceLoader;
import com.eastindia.springcloud.designPatterns.simpleFactory.Resource;

public class ClassPathResourceLoader implements IResourceLoader {
    @Override
    public Resource load(String url) {
//        中间省略复杂的创建过程
        return new Resource(url);
    }
}
