package com.eastindia.springcloud.designPatterns.factoryMethod.resourceFactory;

import com.eastindia.springcloud.designPatterns.factoryMethod.resourceFactory.impl.ClassPathResourceLoader;
import com.eastindia.springcloud.designPatterns.factoryMethod.resourceFactory.impl.DefaultResourceLoader;
import com.eastindia.springcloud.designPatterns.factoryMethod.resourceFactory.impl.FileResourceLoader;
import com.eastindia.springcloud.designPatterns.factoryMethod.resourceFactory.impl.HttpResourceLoader;
import com.eastindia.springcloud.designPatterns.simpleFactory.Resource;
import com.eastindia.springcloud.designPatterns.simpleFactory.ResourceException;
import com.eastindia.springcloud.designPatterns.simpleFactory.ResourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ResourceLoader {

    private IResourceLoader resourceLoader;

    private static Map<String, IResourceLoader> resourceLoaderCache = new HashMap<>();

//    版本2
//    static {
//        resourceLoaderCache.put("http", new HttpResourceLoader());
//        resourceLoaderCache.put("file", new FileResourceLoader());
//        resourceLoaderCache.put("classpath", new ClassPathResourceLoader());
//        resourceLoaderCache.put("default", new DefaultResourceLoader());
//    }

//    版本3（终极版本），加载配置文件到缓存中
//    1、完全满足开闭原则，当需要扩充需求时，只需要新增实现和修改配置文件，不需要修改代码
//    2、资源不能被缓存，否则每次获取都获取到的是同一个资源
    static {

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("resourceLoader.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);

            for (Map.Entry en : properties.entrySet()) {

                String key = en.getKey().toString();
                Class<?> clazz = Class.forName(en.getValue().toString());
                IResourceLoader loader = (IResourceLoader) clazz.getConstructor().newInstance();
                resourceLoaderCache.put(key, loader);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    /**
     *
     * @param url file://   http://    classpath://   ftp://
     * @return 资源类
     */
    public Resource load(String url) {

//        1、根据url获取前缀
        String prefix = getPrefix(url);
//        2、根据前缀选择不同的工厂生产独自的产品
//        版本1
//        if ("http".equals(url)) {
////            发起请求，下载资源等。。。
//            resourceLoader = new HttpResourceLoader();
////            return new Resource(url);
//        } else if ("file".equals(url)) {
////            建立流等
//            resourceLoader = new FileResourceLoader();
////            return new Resource(url);
//        } else if ("classpath".equals(url)) {
////            。。。
//            resourceLoader = new ClassPathResourceLoader();
////            return new Resource(url);
//        } else {
//            resourceLoader = new DefaultResourceLoader();
////            return new Resource("default");
//        }
//        return resourceLoader.load(url);
        return ResourceLoader.resourceLoaderCache.get(prefix).load(url);
    }

    private String getPrefix(String url) {
        if (null == url || "".equals(url) || !url.contains(":")) {
            throw new ResourceException("传入的资源url不合法！");
        }
        String[] split = url.split(":");
        return split[0];
    }

}
