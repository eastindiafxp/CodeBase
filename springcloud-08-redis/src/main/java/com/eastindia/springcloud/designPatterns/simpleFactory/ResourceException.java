package com.eastindia.springcloud.designPatterns.simpleFactory;

/**
 * 资源加载异常
 */
public class ResourceException extends RuntimeException {

    public ResourceException() {
        super("加载资源时发生问题！");
    }

    public ResourceException(String message) {
        super(message);
    }

}
