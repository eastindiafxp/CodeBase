package com.eastindia.springcloud.designPatterns.factoryMethod2.product;

import java.io.InputStream;

public abstract class AbstrctResource {

    private String url;

    public AbstrctResource() {}

    public AbstrctResource(String url) {
        this.url = url;
    };

    protected void shared() {
        System.out.println("这是共享方法！");
    }

    /**
     * 每个子类需要独自实现的方法
     * @return
     */
    public abstract InputStream getInputStream();

}
