package com.watimer.study.singleton;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/8/3
 */

// 饿汉式单利 类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;
    }
}
