package com.example.demo.domain;

/**
 * @author MrBird
 */
public class User {

    public User() {
        System.out.println("调用无参构造器创建User");
    }

    public void init() {
        System.out.println("initMethod 初始化User");
    }

    public void destory() {
        System.out.println("destroyMethod 销毁User");
    }
}
