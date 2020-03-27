package com.watimer.study.mail.reflect;

import java.math.BigDecimal;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/1/31
 */
public class Phone {

    private final static String TAG = "PhoneTag";

    private String name;

    private String color;

    private int price;

    @Override
    public String toString(){

        return "Phone{" +
                "name='" + name + '\'' + ",color='"+color+ '\'' + ",price='"+price+ '\'' + '}';
    }


    public Phone(){}

    private Phone(String name,String color,int price){
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getName(){
        return name;
    }


    public void setName(String name){
        this.name = name;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    private String declaredMethod(int index){
        String string = null;
        switch (index){
            case 0:
                string = "I am declaredMethod 1 !";
            case 1:
                string = "I am declaredMethod 2 !";
            default:
                string = "I am declaredMethod 1 !";
        }
        return string;
    }
}
