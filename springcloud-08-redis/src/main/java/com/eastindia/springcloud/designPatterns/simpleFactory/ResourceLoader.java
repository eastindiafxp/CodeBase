package com.eastindia.springcloud.designPatterns.simpleFactory;

public class ResourceLoader {

    /**
     *
     * @param url file://   http://    classpath://   ftp://
     * @return 资源类
     */
    public Resource load(String url) {

//        1、根据url获取前缀
        String prefix = getPrefix(url);
//        2、根据前缀处理不同的资源
        return ResourceFactory.create(prefix, url);

    }

    private String getPrefix(String url) {
        if (null == url || "".equals(url) || !url.contains(":")) {
            throw new ResourceException("传入的资源url不合法！");
        }
        String[] split = url.split(":");
        return split[0];
    }

}
