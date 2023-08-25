package com.eastindia.springcloud.designPatterns.factoryMethod2.resourceFactory;

import com.eastindia.springcloud.designPatterns.simpleFactory.Resource;

public interface IResourceLoader {

    Resource load(String url);

}
