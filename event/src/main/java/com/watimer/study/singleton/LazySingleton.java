package com.watimer.study.singleton;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/8/3
 */
// 懒汉式单利 只有当第一次调用 getlnstance 方法时才去创建这个单例
public class LazySingleton {

    private static volatile LazySingleton instance = null;

    private LazySingleton(){}

    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            System.out.println("创建实例");
            instance = new LazySingleton();
        } else {
            System.out.println("已存在实例,不再创建");
        }
        return instance;
    }
}
