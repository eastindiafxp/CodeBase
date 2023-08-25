package com.eastindia.springcloud.designPatterns.simpleFactory;

public class ResourceFactory {

    public static Resource create(String type, String url) {

        if ("http".equals(type)) {
//            发起请求，下载资源等。。。
            return new Resource(url);
        } else if ("file".equals(type)) {
//            建立流等
            return new Resource(url);
        } else if ("classpath".equals(type)) {
//            。。。
            return new Resource(url);
        } else {
            return new Resource("default");
        }
    }


}
