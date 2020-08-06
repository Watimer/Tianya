package com.watimer.study.singleton;


/**
 * @param
 * @author yan
 * @Description
 * @date 2020/8/3
 */
public class SingletonEager {

    public static void main(String[] args){
        Presidents zt1 = Presidents.getInstance();
        Presidents zt2 = Presidents.getInstance();
        Presidents zt3 = Presidents.getInstance();
        Presidents zt4 = Presidents.getInstance();
        if(zt1 == zt2 && zt1 == zt3 && zt1 == zt4){
            System.out.println("他们是同一人！");
        } else {
            System.out.println("他们不是同一人！");
        }
    }
}

class Presidents {

    private static Presidents instance = new Presidents();

    private Presidents(){
        System.out.println("总统奥巴马");
    }

    public static Presidents getInstance(){
        return instance;
    }
}