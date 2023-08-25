package com.eastindia.springcloud.designPatterns.factoryMethod.resourceFactory;

import com.eastindia.springcloud.designPatterns.simpleFactory.Resource;

public interface IResourceLoader {

    Resource load(String url);

}
