package com.eastindia.springcloud.designPatterns.simpleFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 一个资源类很复杂
 * 课堂上的例子简单，但是不代表真实情况简单
 * 学习设计模式有一个重要的作用就是写出可扩展、易阅读、可测试、高性能的代码
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Resource {

    public Resource(String url) {}


}
